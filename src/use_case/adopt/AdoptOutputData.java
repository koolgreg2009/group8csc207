package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/** Returns Data for Adopt
 */
public class AdoptOutputData {
    private Pet pet;

    /** Constructor for AdoptOutputData\
     * @param pet
     */
    public AdoptOutputData(Pet pet){
        this.pet = pet;
    }

    /** method to return petid
     * @return petID
     */
    public Integer getPetID() {
        return pet.getPetID();
    }

    /** method to return pet owner
     */
    public String getPetOwner(){
        return pet.getOwner();
    }

}
