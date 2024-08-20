package use_case.display_pets;

/**
 * Output boundary interface for displaying pets.
 * <p>
 * This interface defines a method for preparing the output data needed to display pets to the user.
 * It is used by the interactor to send data to the presenter or view that will handle displaying the pets.
 * </p>
 */
public interface DisplayPetsOutputBoundary {

    /**
     * Prepares the output for displaying pets after retrieving and processing the relevant data.
     *
     * @param loggedInOutput the data to be displayed, including user information and a list of pet DTOs
     */
    void prepareLoggedIn(DisplayPetsOutputData loggedInOutput);
}
