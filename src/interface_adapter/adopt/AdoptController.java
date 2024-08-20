package interface_adapter.adopt;

import use_case.adopt.AdoptInputBoundary;
import use_case.adopt.AdoptInputData;

/**
 * The {@link AdoptController} class is responsible for handling adoption requests.
 * It interacts with the {@link AdoptInputBoundary} to process adoption-related operations.
 */
public class AdoptController {
    private final AdoptInputBoundary adoptInteractor;

    /**
     * Constructs an {@link AdoptController} with the specified {@link AdoptInputBoundary} for processing adoption requests.
     *
     * @param adoptInteractor the input boundary used to interact with the adoption use case
     */
    public AdoptController(AdoptInputBoundary adoptInteractor) {
        this.adoptInteractor = adoptInteractor;
    }

    /**
     * Executes the adoption process for a pet with the given pet ID.
     * Creates an {@link AdoptInputData} instance with the specified pet ID and passes it to the {@link AdoptInputBoundary}.
     *
     * @param petID the ID of the pet to be adopted
     */
    public void execute(int petID){
        this.adoptInteractor.execute(new AdoptInputData(petID));
    }
}
