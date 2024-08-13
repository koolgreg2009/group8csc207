package data_access;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import entity.Pet;
import entity.preference.UserPreference;

public interface PetDAOInterface {

    void save(Pet pet);

    Pet get(int petID);

    ArrayList<Pet> getPreferencePets(UserPreference userPreference);


}
