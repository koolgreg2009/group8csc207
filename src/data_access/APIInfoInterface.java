package data_access;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;

/**
 * The APIInfoInterface defines the contract for interacting with an API to retrieve and manage data.
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
     * Parses breedInfo
     */

    void getBreedInfo() throws IOException;

    void getLocation() throws IOException;

    /**
     * Persists or saves the data that has been retrieved or modified.
     */
    void save();

    boolean exists(String string, String key);

    boolean exists(List<String> strings, String key);
}
