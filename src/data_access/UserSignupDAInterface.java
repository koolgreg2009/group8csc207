package data_access;

import entity.user.User;

public interface UserSignupDAInterface {

    boolean existsByName(String identifier);

    void save(User user);

}
