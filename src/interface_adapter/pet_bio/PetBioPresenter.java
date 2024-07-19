package interface_adapter.pet_bio;

import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;

public class PetBioPresenter implements PetBioOutputBoundary {

    @Override
    public void preparePetBio(PetBioOutputData petBio) {
        //quote in front allows for petBio.getPet() to know it's a string, and calls its toString method
        System.out.println("" + petBio.getPet());
    }
}
