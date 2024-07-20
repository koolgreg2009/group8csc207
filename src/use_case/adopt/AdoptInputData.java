package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/** Getting data for Adopt
 */
public class AdoptInputData {
    //private Pet pet;
    private int petId;

    public AdoptInputData(int petId) {
        this.petId = petId;
    }
    public int getPetID(){
        return petId;
    }
}
