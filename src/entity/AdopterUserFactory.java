package entity;

import utils.IdCounter;

public class AdopterUserFactory implements UserFactory {

    @Override
    public User create(String username, String password, Profile userProfile){
        long userID = IdCounter.getNextID();
        return new AdopterUser(userID, username, password, userProfile);
    }
}
