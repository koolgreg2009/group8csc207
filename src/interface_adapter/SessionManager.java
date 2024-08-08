package interface_adapter;

import entity.user.User;

public class SessionManager {
    private static String currentUser;

    private SessionManager() {} // Private constructor to prevent instantiation

    public static void login(String user) {
        currentUser = user;
    }

    public static void logout() { // call in logoutusecasepresenter
        currentUser = null;
    }

    public static String getCurrentUser() { // call in all use case controllers that need logged in user info
        return currentUser;
    }
}
