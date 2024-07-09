package entity.User;

public class AdopterUserFactory implements UserFactory {

    @Override
    public User create(String username, String password, String name, String email, String phone){
        return new AdopterUser(username, password, name, email, phone);
    }
}
