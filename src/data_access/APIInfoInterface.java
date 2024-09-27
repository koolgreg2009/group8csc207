package data_access;

import java.io.IOException;
import java.util.List;

/**
 * The {@code APIInfoInterface} defines the contract for interacting with an API to retrieve and manage data.
 * This interface provides methods for obtaining, parsing, checking the existence, and saving data related to
 * different keys such as breed information and location data.
 */
public interface APIInfoInterface {

    /**
     * Retrieves a list of data associated with the specified key.
     *
     * @param key the key used to identify the data to retrieve.
     * @return a list of strings representing the data associated with the specified key.
     */
    List<String> getData(String key);

    /**
     * Retrieves and parses breed information from the API.
     *
     * @throws IOException if an I/O error occurs during the API interaction.
     */
    void getBreedInfo() throws IOException;

    /**
     * Retrieves and parses location information from the API.
     *
     * @throws IOException if an I/O error occurs during the API interaction.
     */
    void getLocation() throws IOException;

    /**
     * Persists or saves the data that has been retrieved or modified.
     *
     * @param key the key used to identify the data to save.
     * @param breedNames a list of strings representing the breed names to save.
     */
    void save(String key, List<String> breedNames);

    /**
     * Checks if a specific string exists in the data associated with the specified key.
     *
     * @param string the string to check for existence.
     * @param key the key used to identify the data to check against.
     * @return {@code true} if the string exists, {@code false} otherwise.
     */
    boolean exists(String string, String key);

    /**
     * Checks if any of the specified strings exist in the data associated with the specified key.
     *
     * @param strings a list of strings to check for existence.
     * @param key the key used to identify the data to check against.
     * @return {@code true} if any of the strings exist, {@code false} otherwise.
     */
    boolean exists(List<String> strings, String key);
}
