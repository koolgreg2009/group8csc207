package utils;

/**
 * Manages the session for the current user. This class handles user login and logout operations
 * and provides methods to retrieve the currently logged-in user's information.
 * <p>
 * This class should not be instantiated. Uses singleton pattern so only one instance of it can exist at a time.
 */
public class SessionManager {
    private String currentUser;
    private static SessionManager instance;

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private SessionManager() {}

    /**
     * Singleton design pattern, gets SessionManager instance,
     * @return SessionManager instnace
     */
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    /**
     * Logs in the specified user by setting the current user.
     *
     * @param user the username of the user to be logged in
     */
    public void login(String user) {
        this.currentUser = user;
    }

    /**
     * Logs out the current user by clearing the current user information.
     * This method should be called to end the session for the current user.
     */
    public void logout() { // call in logoutusecasepresenter
        this.currentUser = null;
    }

    /**
     * Retrieves the username of the currently logged-in user.
     *
     * @return the username of the current user, or {@code null} if no user is logged in
     */
    public String getCurrentUser() { // call in all use case controllers that need logged in user info
        return currentUser;
    }
}
