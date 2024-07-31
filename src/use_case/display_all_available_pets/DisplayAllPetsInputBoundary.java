package use_case.display_all_available_pets;

/**
 * This interface defines the contract for displaying all pets for a specific user.
 * <p>
 * Implementations of this interface will handle the logic required to retrieve and display
 * all pets based on the provided input data.
 */
public interface DisplayAllPetsInputBoundary {

    /**
     * Executes the process of displaying all pets for a specific user based on the input data.
     *
     * @param displayAllPetsInputData the data required to display all pets for the user
     */
    void execute(DisplayAllPetsInputData displayAllPetsInputdata);
}
