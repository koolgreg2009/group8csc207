package use_case.pet_bio;


public class PetBioInputData {

    private final int petID;

    public PetBioInputData(int petID) {
        this.petID = petID;
    }

    public int getPetID() {return petID;}
}
