package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/** Returns Data for Adopt
 */
public class AdoptOutputData {
    private Pet pet;
    private List<User> userList;

    public AdoptOutputData(Pet pet){
        this.pet = pet;
    }

    public Integer getPetID() {
        return pet.getPetID();
    }

    public String getPetOwner(){
        return pet.getOwner();
    }

}
