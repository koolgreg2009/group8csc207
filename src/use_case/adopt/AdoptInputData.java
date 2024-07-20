package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/** Getting data for Adopt
 */
public class AdoptInputData {
    private int petId;

    /**
     * This is the constructor for the AdoptInputData class.
     *
     * @param petId The ID of the pet.
     */
    public AdoptInputData(int petId) {
        this.petId = petId;
    }

    /**
     * Method to return petid
     * @return the pet ID as an int
     */
    public int getPetID(){
        return petId;
    }
}
