package data_access;

import entity.User.User;

public interface UserSignupDAInterface {

    boolean existsByName(String identifier);

    void save(User user);

}
