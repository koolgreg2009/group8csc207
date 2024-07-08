package entity;
import entity.Profile;

public interface UserFactory {
    User create(String username, String password, Profile userProfile);
}
