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

    void fetchAndStorePets() throws IOException;

    Pet parsePet(JsonNode petNode, JsonNode included) throws IOException;

    int parseAgeString(String ageString);
}
