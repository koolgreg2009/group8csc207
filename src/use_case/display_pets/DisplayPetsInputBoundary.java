package use_case.display_pets;

/**
 * Interface defining the input boundary for the display pets use case.
 * <p>
 * This interface outlines the contract for interacting with the use case
 * that handles the display of pets. Implementations should define how to
 * process the input data and trigger the appropriate actions to display
 * the pets.
 * </p>
 */
public interface DisplayPetsInputBoundary {

    /**
     * Executes the process of displaying pets based on the provided input data.
     *
     * @param loggedInInputData the input data containing information required
     *                          for displaying the pets, such as user context or filters
     */
    void execute(DisplayPetsInputData loggedInInputData);
}
