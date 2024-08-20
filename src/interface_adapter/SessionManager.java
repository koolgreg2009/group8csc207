package interface_adapter;

/**
 * Manages the session for the current user. This class handles user login and logout operations
 * and provides methods to retrieve the currently logged-in user's information.
 * <p>
 * This class cannot be instantiated due to its private constructor, and all operations
 * are performed through static methods.
 */
public class SessionManager {
    private static String currentUser;

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private SessionManager() {}

    /**
     * Logs in the specified user by setting the current user.
     *
     * @param user the username of the user to be logged in
     */
    public static void login(String user) {
        currentUser = user;
    }

    /**
     * Logs out the current user by clearing the current user information.
     * This method should be called to end the session for the current user.
     */
    public static void logout() { // call in logoutusecasepresenter
        currentUser = null;
    }

    /**
     * Retrieves the username of the currently logged-in user.
     *
     * @return the username of the current user, or {@code null} if no user is logged in
     */
    public static String getCurrentUser() { // call in all use case controllers that need logged in user info
        return currentUser;
    }
}
