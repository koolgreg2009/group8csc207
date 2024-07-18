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
    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getRepeatPassword() {return repeatPassword;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public String getPhone() {return phone;}
}
