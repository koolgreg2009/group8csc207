package data_access;

import java.util.HashMap;

/**
 * The {@code CatDAOInterface} defines the contract for interacting with data related to cat breeds.
 * This interface provides methods for retrieving information about specific cat breeds.
 */
public interface CatDAOInterface {

    /**
     * Retrieves information related to the specified cat breed.
     *
     * @param breedName the name of the breed for which information is to be retrieved.
     * @return a {@link HashMap} containing key-value pairs representing the breed information.
     */
    HashMap<String, Object> getBreedInformation(String breedName);

}
