package use_case.display;

import use_case.display.DisplayPetsOutputData;

/**
 * This interface defines the contract for presenting the output of displaying all pets.
 *
 * <p>Implementations of this interface will handle the logic required to present the output data
 * that contains the details of all pets to be displayed.
 */
public interface DisplayPetsOutputBoundary {

    /**
     * Presents the output data of all pets for a specific user.
     *
     * @param displayPetsOutputData the data required to display all pets
     */
    void displayPetsOutput(DisplayPetsOutputData displayPetsOutputData);
}
