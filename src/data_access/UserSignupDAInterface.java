package data_access;

import entity.user.User;

/**
 * The UserSignupDAInterface defines the methods for accessing user data in the context of user signup operations.
 * It provides methods to check if a user already exists and to save user data.
 *
 */
public interface UserSignupDAInterface {

    /**
     * Checks if a user with the specified identifier (username) already exists in the data source.
     *
     * @param identifier
     * @return true if a user with the specified username exists, false otherwise.
     */
    boolean existsByName(String identifier);

    /**
     * Saves the specified user to the data source.
     *
     * @param user The user to be saved.
     */
    void save(User user);

}
