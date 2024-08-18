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

public class FilePetDAO extends RescueAPIAbstract implements PetDAOInterface {

    private final Map<String, Pet> pets = new HashMap<>();

    public FilePetDAO(String jsonPath) throws IOException {
        super(jsonPath);
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

    /**
     * Retrieves preference pets
     * @param userPreference
     * @return
     */
    @Override
    public ArrayList<Pet> getPreferencePets(UserPreference userPreference) {
        ArrayList<Pet> matchingPets = new ArrayList<>();
        List<Pet> availablePets = getAvailablePets();
        for (Pet pet : availablePets) {
            if (matchesPreference(pet, userPreference)) {
                matchingPets.add(pet);
            }
        }
        return matchingPets;
    }

    /**
     * Returns pets matching user preference
     * @param pet
     * @param userPreference
     * @return
     */
    private boolean matchesPreference(Pet pet, UserPreference userPreference) {
        return isMatching(userPreference.getSpecies(), pet.getSpecies()) &&
                isMatching(userPreference.getBreeds(), pet.getBreed()) &&
                isInRange(userPreference.getMinAge(), userPreference.getMaxAge(), pet.getPetAge()) &&
                isMatching(userPreference.getActivityLevel(), pet.getActivityLevel()) &&
                isMatching(userPreference.getLocation(), pet.getLocation()) &&
                isMatching(userPreference.getGender(), pet.getGender()) &&
                pet.isAvailable();
    }

    private boolean isMatching(String preference, String attribute) {
        return preference == null || preference.isEmpty() || Objects.equals(preference, attribute);
    }

    private boolean isMatching(List<String> preferences, String attribute) {
        return preferences == null || preferences.isEmpty() || preferences.contains(attribute);
    }

    private boolean isInRange(int min, int max, int value) {
        return (min == 0 || value >= min) && (max == 0 || value <= max);
    }

    /**
     * Calls rescuegroups API and retrieves 100 pets. Calls parsePet helper method to parse json pet and parselocations,
     * @throws IOException
     */
    public void fetchAndStorePets() throws IOException {
        String response = makeAPICall("/public/animals/search/available/cats?limit=100");
        JsonNode root = objectMapper.readTree(response);
        JsonNode data = root.get("data");
        JsonNode included = root.get("included");
        Map<String, String> locationMap = parseLocations(included);
        for (JsonNode petNode : data) {
            Pet pet = parsePet(petNode, locationMap);
            if (pet != null) {
                save(pet);
            }
        }
    }

    /**
     * Helper method for fetchAndStorePets
     * @param included
     * @return Map that maps ID to pet location
     */
    private Map<String, String> parseLocations(JsonNode included) {
        Map<String, String> locationMap = new HashMap<>();
        if (included.isArray()) {
            for (JsonNode item : included) {
                if ("locations".equals(item.path("type").asText())) {
                    String locationId = item.path("id").asText();
                    String cityState = item.path("attributes").path("citystate").asText();
                    locationMap.put(locationId, cityState);
                }
            }
        }
        return locationMap;
    }

    /**
     * Parses pet json into Pet entity following business rules
     * @param petNode
     * @param locationMap
     * @return
     * @throws IOException
     */
    private Pet parsePet(JsonNode petNode, Map<String, String> locationMap) throws IOException {
        String locationId = petNode.path("relationships").path("locations").path("data").get(0).path("id").asText();
        String location = locationMap.get(locationId).isEmpty() ? "N/A" : locationMap.get(locationId);
        String orgId = petNode.get("relationships").get("orgs").get("data").get(0).get("id").asText();
        String orgUrl = "/public/orgs/" + orgId;
        String orgResponseBody = makeAPICall(orgUrl);
        JsonNode orgRoot = objectMapper.readTree(orgResponseBody);
        JsonNode dataNode = orgRoot.get("data");
        JsonNode orgData = dataNode.get(0).get("attributes");
        String owner = orgData.get("name").asText();
        String email = orgData.has("email") ? orgData.get("email").asText().replaceAll("\\s+", "") : "N/A";
        String phoneNum = orgData.has("phone") ? orgData.get("phone").asText().replaceAll("\\s+", "") : "N/A";
        int age = petNode.get("attributes").has("ageString") ? parseAgeString(petNode.get("attributes").get("ageString").asText()) : 0;
        String breed = petNode.get("attributes").get("breedPrimary").asText();
        String desc =  petNode.get("attributes").has("descriptionText") ? removeHTML(petNode.get("attributes").get("descriptionText").asText()) : "N/A";
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
        return Integer.parseInt(split[0]);
    }
    /**
     *
     * @return All pets that are available
     */
	private ArrayList<Pet> getAvailablePets() {
		return pets.values().stream().filter(pet -> pet.isAvailable()).collect(Collectors.toCollection(ArrayList::new));
	}
    private String removeHTML(String text){
        return text.replace("&nbsp;", " ").replace("&#39;", "'").replace("&amp;", "&").replace("&quot;", "\"");
    }
}
