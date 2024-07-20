package use_case.login;

import entity.user.User;

/**
 * The LoginUserDataAccessInterface defines the methods for interacting with the data source
 * related to user login operations. It provides methods to check if a user exists,
 * retrieve user details, and save user data.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface LoginUserDataAccessInterface {

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

    /**
     * Retrieves the user with the specified username from the data source.
     *
     * @param username
     * @return The user with the specified username.
     */
    User get(String username);
}