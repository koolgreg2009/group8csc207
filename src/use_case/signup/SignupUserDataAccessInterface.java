package use_case.signup;

import entity.User.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

}
