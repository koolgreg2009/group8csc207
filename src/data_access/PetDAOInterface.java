package data_access;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;

import entity.Pet;
import entity.preference.UserPreference;

public interface PetDAOInterface {

    boolean matchesPreference(Pet pet, UserPreference userPreference);

    void save(Pet pet);

    Pet get(int petID);

    ArrayList<Pet> getPreferencePets(UserPreference userPreference);

    ArrayList<Pet> getAvailablePets();

    Pet parsePet(JsonNode petNode) throws IOException;

}
