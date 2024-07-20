package use_case.signup;

import entity.user.User;


/**
 * The SignupUserDataAccessInterface defines the methods for interacting with the data source
 * related to user signup operations. It provides methods to check if a user exists and to save a user.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface SignupUserDataAccessInterface {

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
     * @param user
     */
    void save(User user);
}