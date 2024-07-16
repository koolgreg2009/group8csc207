package entity.User;

import java.time.LocalDateTime;

public class AdopterUserFactory implements UserFactory {

    @Override
    public AdopterUser create(String username, String password, String name, String email, String phone){
        return new AdopterUser(username, password, name, email, phone);
    }



}
