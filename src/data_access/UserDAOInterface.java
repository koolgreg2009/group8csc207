package data_access;
import entity.User.User;

public interface UserDAOInterface {
    void save(User user);
    boolean existsByName(String identifier);

}
