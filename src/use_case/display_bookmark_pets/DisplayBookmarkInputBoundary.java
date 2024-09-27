package use_case.display_bookmark_pets;

/**
 * The input boundary for the display bookmark process, defining the contract for
 * interacting with the use case that displays bookmarked pets.
 * <p>
 * Implementations of this interface handle the execution of logic related to retrieving and displaying
 * pets that have been bookmarked by the user.
 * </p>
 */
public interface DisplayBookmarkInputBoundary {

    /**
     * Executes the process to retrieve and display bookmarked pets based on the provided input data.
     *
     * @param displayBookmarkInputData the data required to retrieve and display the bookmarked pets, which includes
     *                                 information such as the user's identification and any other relevant details
     */
    void execute(DisplayBookmarkInputData displayBookmarkInputData);
}
