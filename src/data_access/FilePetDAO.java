package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Pet;
import entity.preference.UserPreference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


/**
 * Data Access Object for Pet entities, which uses a JSON file for storage.
 */
public class FilePetDAO implements PetDAOInterface{
    private final File jsonFile;

    private final Map<String, Pet> pets = new HashMap<String, Pet>();

    /**
     * Constructor for the pet entity data access object from the json file path.
     *
     * @param jsonPath the json file path that the data access object is accessing
     * @throws IOException if in IO error occurs
     */
    public FilePetDAO(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        if (jsonFile.length() == 0) {
            save();
        } else {
            TypeReference<HashMap<String, Pet>> typeRef = new TypeReference<HashMap<String, Pet>>() {
            };
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            pets.putAll(objectMapper.readValue(jsonFile, typeRef));
        }
    }

    /**
     * Gets the pet with the pet ID that is specified.
     *
     * @param petID the ID of the et being retrieved
     * @return the Pet with the pet ID that was specified, or null if the pet ID does not belong to an existing Pet.
     */
    @Override
    public Pet get(int petID) {
        return pets.get(String.valueOf(petID));
    }

    /**
     * Saves the Pet specified to the storage map.
     *
     * @param pet the Pet that is being saved
     */
    @Override
    public void save(Pet pet) {
        pets.put(String.valueOf(pet.getPetID()), pet); // apparently this autoboxes
        this.save();
    }

    /**
     * Saves the current state of the Pet storage map to the json file.
     */
    private void save() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            objectMapper.writeValue(jsonFile, pets);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

//    @Override
//    public boolean existsByName(String identifier) {
//        return pets.containsKey(identifier);
//    }

    /**
     * Gets a list of the Pets that align with the UserPreference specified.
     *
     * @param userPreference the UserPreference that the listed pets are aligning to
     * @return the list of Pets that match the UserPreference specified
     */
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

    /**
     * Checks if the Pet matches the preferences indicated in the specified UserPreference.
     *
     * @param pet the Pet being checked
     * @param userPreference the UserPreferences that the Pet is being compared to
     * @return true if the Pet matches the preferences from UserPreference or false in any other outcome
     */
    public boolean matchesPreference(Pet pet, UserPreference userPreference) {
        if (userPreference.getSpecies() != null && !userPreference.getSpecies().isEmpty() && !userPreference.getSpecies().equals(pet.getSpecies())) {
            return false;
        }
        if (userPreference.getBreeds() != null && !userPreference.getBreeds().isEmpty() && !userPreference.getBreeds().contains(pet.getBreed())) {
            return false;
        }
        if (userPreference.getMinAge() != 0 && pet.getAge() < userPreference.getMinAge()) {
            return false;
        }
        if (userPreference.getMaxAge() != 0 && pet.getAge() > userPreference.getMaxAge()) {
            return false;
        }
        if (userPreference.getActivityLevel() != null && !userPreference.getSpecies().isEmpty()&& !userPreference.getActivityLevel().equals(pet.getActivityLevel())) {
            return false;
        }
        if (userPreference.getLocation() != null && !userPreference.getSpecies().isEmpty() && !userPreference.getLocation().equals(pet.getLocation())) {
            return false;
        }
        if (userPreference.getGender() != null && !userPreference.getSpecies().isEmpty() && !userPreference.getGender().equals(pet.getGender())) {
            return false;
        }

        return true;
    }


}
