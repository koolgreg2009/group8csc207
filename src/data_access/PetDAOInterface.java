package data_access;

import com.fasterxml.jackson.databind.JsonNode;
import entity.preference.UserPreference;
import entity.Pet;

import java.io.IOException;
import java.util.ArrayList;

public interface PetDAOInterface {
    boolean matchesPreference(Pet pet, UserPreference userPreference);
    void save(Pet pet);
    Pet get(int petID);
    ArrayList<Pet> getPreferencePets(UserPreference userPreference);

    Pet parsePet(JsonNode petNode) throws IOException;
}
