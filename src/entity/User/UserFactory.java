package entity.User;

public interface UserFactory {
    User create(String username, String password, String name, String email, String phone);
}
