package data_access;

import entity.Pet;
import entity.Preference.UserPreference;

import java.util.ArrayList;

public interface PetDAOInterface {
    boolean matchesPreference(Pet pet, UserPreference userPreference);
    void save(Pet pet);
    Pet get(int petID);
    ArrayList<Pet> getPreferencePets(UserPreference userPreference);

}
