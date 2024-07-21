package interface_adapter.pet_bio;

import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;

/**
 * Presenter for the pet bio information, it implements the output boundary for the pet bio use case.
 */
public class PetBioPresenter implements PetBioOutputBoundary {

    /**
     * Prepares and presents the pet bio info.
     *
     * @param petBio the data output that holds the pet bio information
     */
    @Override
    public void preparePetBio(PetBioOutputData petBio) {
        //quote in front allows for petBio.getPet() to know it's a string, and calls its toString method
        System.out.println(petBio.getPet());
    }
}
