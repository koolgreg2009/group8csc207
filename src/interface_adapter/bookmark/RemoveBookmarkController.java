package interface_adapter.bookmark;

import interface_adapter.SessionManager;
import use_case.bookmarks.BookmarkInputBoundary;
import use_case.bookmarks.BookmarkInputData;

/**
 * Controller class responsible for removing bookmarks.
 */
public class RemoveBookmarkController {
    private final BookmarkInputBoundary removeBookmarkInteractor;

    /**
     * Constructs a RemoveBookmarkController with the given BookmarkInputBoundary.
     *
     * @param removeBookmarkInteractor The interactor that handles the bookmark removal logic.
     */
    public RemoveBookmarkController(BookmarkInputBoundary removeBookmarkInteractor) {
        this.removeBookmarkInteractor = removeBookmarkInteractor;
    }

    /**
     * Executes the process of removing a bookmark for a given user.
     * Prompts the user to enter the ID of the pet they want to remove the bookmark and processes the input.
     *
     */
    public void execute(int petID){
        this.removeBookmarkInteractor.execute(new BookmarkInputData(SessionManager.getInstance().getCurrentUser(), petID));
    }
}
