package entity.user;

import java.util.List;

/**
 * Interface representing a user with common attributes and actions.
 * <p>
 * This interface defines the essential methods for interacting with user data, including
 * retrieving and updating user attributes such as username, password, name, email, phone number,
 * and notifications.
 */
public interface User {
    /**
     * Retrieves the username of the user.
     *
     * @return the username of the user
     */
    String getUsername();

    /**
     * Sets the username for the user.
     *
     * @param username the new username for the user
     */
    void setUsername(String username);

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user
     */
    String getPassword();

    /**
     * Sets the password for the user.
     *
     * @param password the new password for the user
     */
    void setPassword(String password);

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    String getName();

    /**
     * Sets the name for the user.
     *
     * @param name the new name for the user
     */
    void setName(String name);

    /**
     * Retrieves the email address of the user.
     *
     * @return the email address of the user
     */
    String getEmail();

    /**
     * Sets the email address for the user.
     *
     * @param email the new email address for the user
     */
    void setEmail(String email);

    /**
     * Retrieves the phone number of the user.
     *
     * @return the phone number of the user
     */
    String getPhone();

    /**
     * Sets the phone number for the user.
     *
     * @param num the new phone number for the user
     */
    void setPhone(String num);

    /**
     * Adds a notification to the user's list of notifications.
     *
     * @param notif the notification to be added
     */
    void addNotif(String notif);
}
