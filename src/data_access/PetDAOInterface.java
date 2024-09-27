package data_access;

import java.util.ArrayList;
import entity.Pet;
import entity.preference.UserPreference;

/**
 * Defines the contract for interacting with pet data access objects.
 */
public interface PetDAOInterface {

    /**
     * Saves the specified pet to the data store.
     *
     * @param pet the {@link Pet} object to be saved.
     */
    void save(Pet pet);

    /**
     * Retrieves a pet based on its ID.
     *
     * @param petID the ID of the pet to retrieve.
     * @return the {@link Pet} object corresponding to the specified ID.
     */
    Pet get(int petID);

    /**
     * Retrieves a list of pets that match the specified user preferences.
     *
     * @param userPreference the {@link UserPreference} object containing user preferences.
     * @return an {@link ArrayList} of {@link Pet} objects that match the specified preferences.
     */
    ArrayList<Pet> getPreferencePets(UserPreference userPreference);
}
