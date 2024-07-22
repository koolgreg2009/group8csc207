package use_case.adopt;

import entity.Pet;
import entity.user.User;

import java.util.List;

/** Returns Data for Adopt
 */
public class AdoptOutputData {
    private final String petOwner;
    private final String ownerEmail;
    private final String ownerPhone;
    private final String petID;


    public AdoptOutputData(String petOwner, String ownerEmail, String ownerPhone, String petID){
        this.petOwner = petOwner;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        this.petID = petID;

    }

    public String getPetOwner() {
        return petOwner;
    }
    public String getOwnerEmail() {
        return ownerEmail;
    }
    public String getOwnerPhone() {
        return ownerPhone;
    }
    public String getID() {
        return petID;
    }
}
