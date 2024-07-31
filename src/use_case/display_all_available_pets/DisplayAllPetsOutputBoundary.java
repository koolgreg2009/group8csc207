package use_case.display_all_available_pets;

/**
 * This interface defines the contract for presenting the output of displaying all pets.
 *
 * <p>Implementations of this interface will handle the logic required to present the output data
 * that contains the details of all pets to be displayed.
 */
public interface DisplayAllPetsOutputBoundary {

    /**
     * Presents the output data of all pets for a specific user.
     *
     * @param displayAllPetsOutputData the data required to display all pets
     */
    void displayAllPetsOutput(DisplayAllPetsOutputData displayAllPetsOutputData);
}
