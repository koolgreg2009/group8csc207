package use_case.signup;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private String name;
    final private String email;
    final private String phone;

    public SignupInputData(String username, String password, String repeatPassword, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    String getUsername() {return username;}

    String getPassword() {return password;}

    public String getRepeatPassword() {return repeatPassword;}

    String getName() {return name;}

    String getEmail() {return email;}

    String getPhone() {return phone;}

}