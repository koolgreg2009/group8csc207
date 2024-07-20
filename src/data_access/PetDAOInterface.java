package data_access;

import entity.preference.UserPreference;
import entity.Pet;

import java.util.ArrayList;

public interface PetDAOInterface {
    boolean matchesPreference(Pet pet, UserPreference userPreference);
    void save(Pet pet);
    Pet get(int petID);
    ArrayList<Pet> getPreferencePets(UserPreference userPreference);

}
