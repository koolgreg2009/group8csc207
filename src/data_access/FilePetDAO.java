package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Pet;
import entity.Preference.UserPreference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilePetDAO implements PetDAOInterface{
    private final File jsonFile;

    private final Map<Integer, Pet> pets = new HashMap<Integer, Pet>();

    public FilePetDAO(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        if (jsonFile.length() == 0) {
            save();
        } else {
            TypeReference<HashMap<Integer, Pet>> typeRef = new TypeReference<HashMap<Integer, Pet>>() {
            };
            ObjectMapper objectMapper = new ObjectMapper();
            pets.putAll(objectMapper.readValue(jsonFile, typeRef));
        }
    }
    @Override
    public Pet get(int petID) {
        return pets.get(petID);
    }
    @Override
    public void save(Pet pet) {
        pets.put(pet.getPetID(), pet); // apparently this autoboxes
        this.save();
    }
    private void save() {
        ObjectMapper objectMapper = new ObjectMapper();
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

    public boolean matchesPreference(Pet pet, UserPreference userPreference) {
        if (userPreference.getSpecies() != null && !userPreference.getSpecies().equals(pet.getSpecies())) {
            return false;
        }
        if (userPreference.getBreeds() != null && !userPreference.getBreeds().isEmpty() && !userPreference.getBreeds().contains(pet.getBreed())) {
            return false;
        }
        if (userPreference.getMinAge() != 0 && pet.getAge() <= userPreference.getMinAge()) {
            return false;
        }
        if (userPreference.getMaxAge() != 0 && pet.getAge() >= userPreference.getMaxAge()) {
            return false;
        }
        if (userPreference.getActivityLevel() != null && !userPreference.getActivityLevel().equals(pet.getActivityLevel())) {
            return false;
        }
        if (userPreference.getLocation() != null && !userPreference.getLocation().equals(pet.getLocation())) {
            return false;
        }
        if (userPreference.getGender() != null && !userPreference.getGender().equals(pet.getGender())) {
            return false;
        }

        return true;
    }


}
