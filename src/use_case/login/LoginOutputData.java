package use_case.login;

/**
 * The LoginOutputData class encapsulates the output data of the login process.
 * It contains the username of the user who successfully logged in.
 */
public class LoginOutputData {

    private final String username;

    /**
     * Constructs a new LoginOutputData object with the specified username.
     *
     * @param username the username of the user who successfully logged in
     */
    public LoginOutputData(String username) {
        this.username = username;
    }

    /**
     * Returns the username of the user who successfully logged in.
     *
     * @return the username of the logged-in user
     */
    public String getUsername() {
        return username;
    }

}
