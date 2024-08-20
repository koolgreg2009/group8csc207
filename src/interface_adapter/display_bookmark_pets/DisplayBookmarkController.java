package interface_adapter.display_bookmark_pets;

import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInputData;

/**
 * The {@link DisplayBookmarkController} class is responsible for managing and executing bookmark display operations.
 * It interacts with the {@link DisplayBookmarkInputBoundary} to process the request and manage bookmark data.
 */
public class DisplayBookmarkController {
    private final DisplayBookmarkInputBoundary displayBookmarkInteractor;

    /**
     * Constructs a {@link DisplayBookmarkController} with the specified input boundary.
     *
     * @param displayBookmarkInteractor the boundary used to process bookmark display requests
     */
    public DisplayBookmarkController(DisplayBookmarkInputBoundary displayBookmarkInteractor) {
        this.displayBookmarkInteractor = displayBookmarkInteractor;
    }

    /**
     * Executes the display bookmark operation with the given username.
     * This method creates a {@link DisplayBookmarkInputData} instance with the provided username and passes it to the
     * {@link DisplayBookmarkInputBoundary} for processing.
     *
     * @param username the username whose bookmarks are to be displayed
     */
    public void execute(String username){
        displayBookmarkInteractor.execute(new DisplayBookmarkInputData(username));
    }
}
