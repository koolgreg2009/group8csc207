package entity.user;

public class AdopterUserFactory implements UserFactory {

    @Override
    public AdopterUser createAdopter(String username, String password, String name, String email, String phone){
        return new AdopterUser(username, password, name, email, phone);
    }



}
