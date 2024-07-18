package use_case;

import entity.Pet;
import entity.User.User;

import java.util.List;

/** Returns Data for Adopt
 */
public class AdoptOutputData {
    private Pet pet;
    private List<User> userList;

    public AdoptOutputData(Pet pet, List<User> userList){
        this.pet = pet;
        this.userList = userList;
    }

    public Pet getPet() {
        return pet;
    }

    public List<User> getUserList() {
        return userList;
    }
}
