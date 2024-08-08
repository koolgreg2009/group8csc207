package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/**
 * Encapsulates the input data required for adopting a pet.
 * <p>
 * This class stores the ID of the pet that is being adopted and provides a method to access this ID.
 */
public class AdoptInputData {
    private int petId;

    /**
     * Constructs an {@code AdoptInputData} object with the specified pet ID.
     *
     * @param petId the ID of the pet to be adopted
     */
    public AdoptInputData(int petId) {
        this.petId = petId;
    }

    /**
     * Returns the ID of the pet to be adopted.
     *
     * @return the pet ID
     */
    public int getPetID(){
        return petId;
    }
}
