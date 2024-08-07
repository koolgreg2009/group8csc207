package data_access;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import entity.Pet;
import entity.preference.UserPreference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.IdCounter;

public class FilePetDAO implements PetDAOInterface {
    private final File jsonFile;
    private final String API_KEY = "Av56m5jr";
    private final String BASE_URL = "https://api.rescuegroups.org/v5";
    private final Map<String, Pet> pets = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OkHttpClient client;

    public FilePetDAO(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .build();
        if (jsonFile.length() == 0) {
            fetchAndStorePets();
            save();
        } else {
            TypeReference<HashMap<String, Pet>> typeRef = new TypeReference<HashMap<String, Pet>>() {};
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            pets.putAll(objectMapper.readValue(jsonFile, typeRef));
        }

    }

    @Override
    public Pet get(int petID) {
        return pets.get(String.valueOf(petID));
    }

    @Override
    public void save(Pet pet) {
        pets.put(String.valueOf(pet.getPetID()), pet);
        save();
    }

    private void save(){
        try {
            objectMapper.writeValue(jsonFile, pets);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<Pet> getPreferencePets(UserPreference userPreference) {
        ArrayList<Pet> matchingPets = new ArrayList<>();
        for (Pet pet : pets.values()) {
            if (matchesPreference(pet, userPreference)) {
                matchingPets.add(pet);
            }
        }
        return matchingPets;
    }

    @Override
    public boolean matchesPreference(Pet pet, UserPreference userPreference) {
        return isMatching(userPreference.getSpecies(), pet.getSpecies()) &&
                isMatching(userPreference.getBreeds(), pet.getBreed()) &&
                isInRange(userPreference.getMinAge(), userPreference.getMaxAge(), pet.getPetAge()) &&
                isMatching(userPreference.getActivityLevel(), pet.getActivityLevel()) &&
                isMatching(userPreference.getLocation(), pet.getLocation()) &&
                isMatching(userPreference.getGender(), pet.getGender()) &&
                pet.isAvailable();
    }

    private boolean isMatching(String preference, String attribute) {
        return preference == null || !preference.isEmpty() || Objects.equals(preference, attribute);
    }

    private boolean isMatching(List<String> preferences, String attribute) {
        return preferences == null || !preferences.isEmpty() || preferences.contains(attribute);
    }

    private boolean isInRange(int min, int max, int value) {
        return (min == 0 || value >= min) && (max == 0 || value <= max);
    }

    public void fetchAndStorePets() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/public/animals/search/available/cats")
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                JsonNode root = objectMapper.readTree(responseBody);
                JsonNode data = root.get("data");
                for (JsonNode petNode : data) {
                    Pet pet = parsePet(petNode);
                    if (pet != null) {
                        save(pet);
                    }
                }
            } else {
                throw new IOException("Animal search failed with HTTP code: " + response.code() + " and message: " + response.message());
            }
        }
    }

    private String fetchOrg(String orgUrl) throws IOException {
        Request orgRequest = new Request.Builder()
                .url(orgUrl)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .get()
                .build();
        try (Response orgResponse = client.newCall(orgRequest).execute()) {
            if (orgResponse.isSuccessful() && orgResponse.body() != null) {
                return orgResponse.body().string();
            } else {
                throw new IOException("Failed to fetch organization details with HTTP code: " + orgResponse.code() + " and message: " + orgResponse.message());
            }
        }
    }

    @Override
    public Pet parsePet(JsonNode petNode) throws IOException {
        String orgId = petNode.get("relationships").get("orgs").get("data").get(0).get("id").asText();
        String orgUrl = BASE_URL + "/public/orgs/" + orgId;
        String orgResponseBody = fetchOrg(orgUrl);
        JsonNode orgRoot = objectMapper.readTree(orgResponseBody);
        JsonNode dataNode = orgRoot.get("data");
        JsonNode orgData = dataNode.get(0).get("attributes");
        String owner = orgData.get("name").asText();
        String email = orgData.has("email") ? orgData.get("email").asText().replaceAll("\\s+", "") : "N/A";
        String location = orgData.get("citystate").asText();
        String phoneNum = orgData.has("phone") ? orgData.get("phone").asText().replaceAll("\\s+", "") : "N/A";
        int age = petNode.get("attributes").has("ageString") ? parseAgeString(petNode.get("attributes").get("ageString").asText()) : 0;
        String breed = petNode.get("attributes").get("breedPrimary").asText();
        String desc =  petNode.get("attributes").has("descriptionText") ? petNode.get("attributes").get("descriptionText").asText() : "N/A";
        String activityLevel = petNode.get("attributes").has("activityLevel")
                ? petNode.get("attributes").get("activityLevel").asText()
                : "N/A";
        String gender = petNode.get("attributes").has("sex") ? petNode.get("attributes").get("sex").asText().replaceAll("\\s+", "") : "N/A";
        String name = petNode.get("attributes").has("name") ? petNode.get("attributes").get("name").asText() :
                "N/A";
        String imgUrl = petNode.get("attributes").has("pictureThumbnailUrl") ? petNode.get("attributes").get("pictureThumbnailUrl").asText() : "";
        String parsedUrl = imgUrl.split("\\?")[0];
        return new Pet(
                owner,
                email,
                phoneNum,
                IdCounter.getNextID(),
                "Cat",
                age,
                breed,
                gender,
                activityLevel,
                desc,
                location,
                true,
                name,
                parsedUrl
        );
    }

    /**
     * parses string age into int months
     * @param ageString
     * RI: format must be in x Years y Months format
     * @return age in months
     */

    private int parseAgeString(String ageString) {
        String[] split =  ageString.split(" ");

        return split.length == 4 ? Integer.parseInt(split[0])*12+Integer.parseInt(split[2]) : Integer.parseInt(split[0])*12;
    }

	@Override
	public ArrayList<Pet> getAvailablePets() {
		return pets.values().stream().filter(pet -> pet.isAvailable()).collect(Collectors.toCollection(ArrayList::new));
	}
}
