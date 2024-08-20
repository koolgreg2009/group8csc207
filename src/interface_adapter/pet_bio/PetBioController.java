package interface_adapter.pet_bio;

import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInputData;

/**
 * The controller responsible for handling pet biography requests.
 * Manages interactions between the input boundary and the pet bio use case.
 * This class is in charge of executing the use case by passing input data to the interactor.
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
     * Executes the pet bio use case by passing the provided user name and pet ID as input data to the interactor.
     *
     * @param userName the username of the user requesting the pet bio.
     * @param petID the ID of the pet whose bio is to be retrieved.
     */
    public void execute(String userName, int petID){
        this.petBioInteractor.execute(new PetBioInputData(userName, petID));
    }
}

