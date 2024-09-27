package use_case.signup;

/**
 * The {@code SignupInputData} class encapsulates the data required for signing up a user.
 * It includes fields for username, password, repeated password, name, email, and phone.
 */
public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private String name;
    final private String email;
    final private String phone;

    /**
     * Constructs a new {@code SignupInputData} object with the specified user details.
     *
     * @param username       the username of the user.
     * @param password       the password for the user account.
     * @param repeatPassword the repeated password for confirmation.
     * @param name           the full name of the user.
     * @param email          the email address of the user.
     * @param phone          the phone number of the user.
     */
    public SignupInputData(String username, String password, String repeatPassword, String name, String email,
                           String phone) {
        this.username = username.trim();
        this.password = password.trim();
        this.repeatPassword = repeatPassword.trim();
        this.name = name.trim();
        this.email = email.trim();
        this.phone = phone.trim();
    }

    /**
     * Returns the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the repeated password.
     *
     * @return The repeated password.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Returns the name of the user.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email address of the user.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the phone number of the user.
     *
     * @return The phone.
     */
    public String getPhone() {
        return phone;
    }
}

