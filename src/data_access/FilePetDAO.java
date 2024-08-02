package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entity.Pet;
import entity.preference.UserPreference;
import okhttp3.*;
import utils.IdCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    }

    private void save() {
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
        if (userPreference.getSpecies() != null && !userPreference.getSpecies().isEmpty() && !userPreference.getSpecies().equals(pet.getSpecies())) {
            return false;
        }
        if (userPreference.getBreeds() != null && !userPreference.getBreeds().isEmpty() && !userPreference.getBreeds().contains(pet.getBreed())) {
            return false;
        }
        if (userPreference.getMinAge() != 0 && pet.getPetAge() < userPreference.getMinAge()) {
            return false;
        }
        if (userPreference.getMaxAge() != 0 && pet.getPetAge() > userPreference.getMaxAge()) {
            return false;
        }
        if (userPreference.getActivityLevel() != null && !userPreference.getActivityLevel().isEmpty() && !userPreference.getActivityLevel().equals(pet.getActivityLevel())) {
            return false;
        }
        if (userPreference.getLocation() != null && !userPreference.getLocation().isEmpty() && !userPreference.getLocation().equals(pet.getLocation())) {
            return false;
        }
        if (userPreference.getGender() != null && !userPreference.getGender().isEmpty() && !userPreference.getGender().equals(pet.getGender())) {
            return false;
        }
        return true;
    }

    @Override
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
    @Override
    public String fetchOrg(String orgId, String orgUrl) throws IOException {
        Request orgRequest = new Request.Builder()
                .url(orgUrl)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .get()
                .build();
        try (Response orgResponse = client.newCall(orgRequest).execute()) {
            if (orgResponse.isSuccessful() && orgResponse.body() != null) {
                String orgResponseBody = orgResponse.body().string();
                return orgResponseBody;
            } else {
                throw new IOException("Failed to fetch organization details with HTTP code: " + orgResponse.code() + " and message: " + orgResponse.message());
            }
        }
    }

    @Override
    public Pet parsePet(JsonNode petNode) throws IOException {
        String orgId = petNode.get("relationships").get("orgs").get("data").get(0).get("id").asText();
        String orgUrl = BASE_URL + "/public/orgs/" + orgId;
        String orgResponseBody = fetchOrg(orgId, orgUrl);
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

    @Override
    public Pet parsePet(JsonNode petNode, JsonNode included) throws IOException {
        return null;
    }


    /**
     * parses string age into int months
     * @param ageString
     * RI: format must be in x Years y Months format
     * @return age in months
     */
    @Override
    public int parseAgeString(String ageString) {
        String[] split =  ageString.split(" ");
        return split.length == 4 ? Integer.parseInt(split[0])*12+Integer.parseInt(split[2]) : Integer.parseInt(split[0])*12;
    }
}
