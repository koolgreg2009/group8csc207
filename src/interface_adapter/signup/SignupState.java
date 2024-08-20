package interface_adapter.signup;

/**
 * Represents the state of the signup process, including user input and any validation errors.
 * This class holds information about the user's signup details and provides methods to get
 * and set these details, along with any error messages related to them.
 */
public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;
    private String name = "";
    private String nameError = null;
    private String email = "";
    private String emailError = null;
    private String phone = "";
    private String phoneError = null;

    /**
     * Constructs a new SignupState as a copy of an existing SignupState.
     *
     * @param copy The SignupState to copy.
     */
    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
        repeatPasswordError = copy.repeatPasswordError;
        name = copy.name;
        nameError = copy.nameError;
        email = copy.email;
        emailError = copy.emailError;
        phone = copy.phone;
        phoneError = copy.phoneError;
    }

    /**
     * Constructs a default SignupState with empty fields.
     */
    public SignupState() {}

    /**
     * Gets the username.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username error message.
     *
     * @return the username error message, or null if there is no error.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the password error message.
     *
     * @return the password error message, or null if there is no error.
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Gets the repeated password.
     *
     * @return the repeated password.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the repeated password error message.
     *
     * @return the repeated password error message, or null if there is no error.
     */
    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name error message.
     *
     * @return the name error message, or null if there is no error.
     */
    public String getNameError() {
        return nameError;
    }

    /**
     * Gets the email.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the email error message.
     *
     * @return the email error message, or null if there is no error.
     */
    public String getEmailError() {
        return emailError;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the phone number error message.
     *
     * @return the phone number error message, or null if there is no error.
     */
    public String getPhoneError() {
        return phoneError;
    }

    /**
     * Sets the username.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username.trim();
    }

    /**
     * Sets the username error message.
     *
     * @param usernameError the error message to set for the username.
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password.trim();
    }

    /**
     * Sets the password error message.
     *
     * @param passwordError the error message to set for the password.
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets the repeated password.
     *
     * @param repeatPassword the repeated password to set.
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword.trim();
    }

    /**
     * Sets the repeated password error message.
     *
     * @param repeatPasswordError the error message to set for the repeated password.
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set.
     */
    public void setName(String name) { this.name = name.trim(); }

    /**
     * Sets the name error message.
     *
     * @param nameError the error message to set for the name.
     */
    public void setNameError(String nameError) { this.nameError = nameError; }

    /**
     * Sets the email.
     *
     * @param email the email to set.
     */
    public void setEmail(String email) { this.email = email.trim(); }

    /**
     * Sets the email error message.
     *
     * @param emailError the error message to set for the email.
     */
    public void setEmailError(String emailError) { this.emailError = emailError; }

    /**
     * Sets the phone number.
     *
     * @param phone the phone number to set.
     */
    public void setPhone(String phone) { this.phone = phone.trim(); }

    /**
     * Sets the phone error message.
     *
     * @param phoneError the error message to set for the phone number.
     */
    public void setPhoneError(String phoneError) { this.phoneError = phoneError; }

    /**
     * Returns a string representation of the SignupState, including the values of all fields.
     *
     * @return a string representation of the SignupState.
     */
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                "name='" + name + '\'' +
                "email='" + email + '\'' +
                "phone='" + phone + '\'' +
                '}';
    }
}
