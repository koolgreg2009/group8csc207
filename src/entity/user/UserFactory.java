package entity.user;

public interface UserFactory {
    AdopterUser createAdopter(String username, String password, String name, String email, String phone);

}
