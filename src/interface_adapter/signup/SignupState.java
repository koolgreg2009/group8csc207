package interface_adapter.signup;

/**
 * Represents the state of the signup process, which includes user input and any validation errors.
 *
 * @version 1.0
 * @since 2024-07-20
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
     * Constructor for creating a new copy of SignupState based on an existing SignupState.
     *
     * @param copy SignupState to copy
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
     * Constructor to create a default SignupState that is empty.
     */
    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignupState() {}

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username error message
     *
     * @return the username error if there is one
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
     * @return the password error if there is one
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Gets the repeated password
     *
     * @return the repeated password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the repeat password error.
     *
     * @return the repeat password error if there is one
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
     * Gets the name error message
     *
     * @return the name error if there is one
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
     * Gets the email error message
     *
     * @return the email error if there is one
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
     * Gets the phone number error message
     *
     * @return the phone number error if there is one
     */
    public String getPhoneError() {
        return phoneError;
    }

    /**
     * Sets the username.
     *
     * @param username the username being set
     */
    public void setUsername(String username) {
        this.username = username.trim();
    }

    /**
     * Sets the username error message.
     *
     * @param usernameError the error and message being sent if there is a username error
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password the password being set
     */
    public void setPassword(String password) {
        this.password = password.trim();
    }

    /**
     * Sets the password error message.
     *
     * @param passwordError the error and message being sent if there is a password error
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets the repeated password
     *
     * @param repeatPassword the repeated password being set
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword.trim();
    }

    /**
     * Sets the repeated password error message.
     *
     * @param repeatPasswordError the error and message being sent if there is a repeat password error
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    /**
     * Sets the name.
     *
     * @param name the name being set
     */
    public void setName(String name) { this.name = name.trim(); }

    /**
     * Sets the name error message.
     *
     * @param nameError the error and message being sent if there is a name error
     */
    public void setNameError(String nameError) { this.nameError = nameError; }

    /**
     * Sets the email.
     *
     * @param email the email being set
     */
    public void setEmail(String email) { this.email = email.trim(); }

    /**
     * Sets the email error message.
     *
     * @param emailError the error and message being sent if there is an email error
     */
    public void setEmailError(String emailError) { this.emailError = emailError; }

    /**
     * Sets the phone number.
     *
     * @param phone the phone number being set
     */
    public void setPhone(String phone) { this.phone = phone.trim(); }

    /**
     * Sets the phone error message.
     *
     * @param phoneError the error and message being sent if there is a phone error
     */
    public void setPhoneError(String phoneError) { this.phoneError = phoneError; }

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
