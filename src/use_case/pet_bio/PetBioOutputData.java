package use_case.pet_bio;

import entity.Pet;

public class PetBioOutputData {

    private Pet pet;

    public PetBioOutputData(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

}
