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

/**
 * The {@code FilePetDAO} class is responsible for handling the retrieval, parsing, and saving
 * of pet data to a JSON file. It implements the {@link PetDAOInterface} and interacts with the
 * RescueAPI to fetch pet data based on user preferences and availability.
 */
public class FilePetDAO extends RescueAPIAbstract implements PetDAOInterface {
    private final Map<String, Pet> pets = new HashMap<>();

    /**
     * Constructs a {@code FilePetDAO} instance and initializes it with data from the specified JSON file.
     * If the JSON file is empty, it retrieves pet data from the API and saves it.
     *
     * @param jsonPath the path to the JSON file that will be used to store the data.
     * @throws IOException if an I/O error occurs while reading the JSON file or interacting with the API.
     */
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

    /**
     * Retrieves a {@link Pet} entity by its ID.
     *
     * @param petID the ID of the pet to retrieve.
     * @return the {@link Pet} entity with the specified ID, or {@code null} if no such pet exists.
     */
    @Override
    public Pet get(int petID) {
        return pets.get(String.valueOf(petID));
    }

    /**
     * Saves a {@link Pet} entity to the JSON file.
     *
     * @param pet the {@link Pet} entity to save.
     */
    @Override
    public void save(Pet pet) {
        pets.put(String.valueOf(pet.getPetID()), pet);
        save();
    }

    /**
     * Persists the current state of the pet data to the JSON file.
     */
    private void save(){
        try {
            objectMapper.writeValue(jsonFile, pets);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    /**
     * Retrieves pets that match the specified user preferences.
     *
     * @param userPreference the user preferences to filter pets by.
     * @return an {@link ArrayList} of {@link Pet} entities that match the user's preferences.
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
     * Checks if a {@link Pet} entity matches the specified user preferences.
     *
     * @param pet the {@link Pet} entity to check.
     * @param userPreference the user preferences to match against.
     * @return {@code true} if the pet matches the user preferences, {@code false} otherwise.
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

    /**
     * Checks if a specific attribute matches the user's preference.
     *
     * @param preference the user's preference for the attribute.
     * @param attribute the attribute to check.
     * @return {@code true} if the attribute matches the preference, {@code false} otherwise.
     */
    private boolean isMatching(String preference, String attribute) {
        return preference == null || preference.isEmpty() || Objects.equals(preference, attribute);
    }

    /**
     * Checks if a list of attributes matches the user's preferences.
     *
     * @param preferences the user's preferences for the attributes.
     * @param attribute the attribute to check.
     * @return {@code true} if the attribute matches one of the preferences, {@code false} otherwise.
     */
    private boolean isMatching(List<String> preferences, String attribute) {
        return preferences == null || preferences.isEmpty() || preferences.contains(attribute);
    }

    /**
     * Checks if a value falls within a specified range.
     *
     * @param min the minimum value of the range.
     * @param max the maximum value of the range.
     * @param value the value to check.
     * @return {@code true} if the value is within the range, {@code false} otherwise.
     */
    private boolean isInRange(int min, int max, int value) {
        return (min == 0 || value >= min) && (max == 0 || value <= max);
    }

    /**
     * Fetches and stores pet data from the RescueAPI.
     *
     * @throws IOException if an I/O error occurs during the API interaction.
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
     * Parses location data from the API response.
     *
     * @param included the included node from the API response.
     * @return a map that associates location IDs with city and state strings.
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
     * Parses a {@link JsonNode} representing a pet into a {@link Pet} entity.
     *
     * @param petNode the {@link JsonNode} representing the pet.
     * @param locationMap a map of location IDs to city and state strings.
     * @return a {@link Pet} entity, or {@code null} if the parsing fails.
     * @throws IOException if an I/O error occurs during the parsing.
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
        String name = "N/A";
        if (petNode.get("attributes").has("name")) {
            name = petNode.get("attributes").get("name").asText();
        }
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
     * Parses a string representing age into an integer value representing months.
     *
     * <p>RI: The format of the ageString must be in "x Years y Months" format.</p>
     *
     * @param ageString the string representing the age of the pet.
     * @return the age of the pet in months.
     */
    private int parseAgeString(String ageString) {
        String[] split =  ageString.split(" ");
        return Integer.parseInt(split[0]);
    }

    /**
     * Retrieves all pets that are available.
     *
     * @return an {@link ArrayList} of {@link Pet} entities that are currently available.
     */
	private ArrayList<Pet> getAvailablePets() {
		return pets.values().stream().filter(pet -> pet.isAvailable()).collect(Collectors.toCollection(ArrayList::new));
	}

    /**
     * Removes common HTML escape characters from a string.
     *
     * @param text the string from which to remove HTML escape characters.
     * @return the cleaned string with HTML escape characters replaced with their corresponding symbols.
     */
    private String removeHTML(String text){
        return text.replace("&nbsp;", " ").replace("&#39;", "'").replace("&amp;", "&").replace("&quot;", "\"");
    }
}
