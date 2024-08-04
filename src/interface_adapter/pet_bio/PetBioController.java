package interface_adapter.pet_bio;

import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInputData;

/**
 * The controller for handling pet biography requests which is in charge of interactions between the input boundary and
 * the pet bio use case.
 */
public class PetBioController {
    private final PetBioInputBoundary petBioInteractor;

    /**
     * The constructor for the controller that handles the pet bio use case.
     *
     * @param petBioInteractor the input boundary interactor for the pet bio use case
     */
    public PetBioController(PetBioInputBoundary petBioInteractor) {
        this.petBioInteractor = petBioInteractor;
    }

    /**
     * Executes the pet bio use case by prompting the user for a pet ID while passing input data to the interactor.
     * @param petID 
     */
    public void execute(int petID){
        this.petBioInteractor.execute(new PetBioInputData(petID));
    }
}

