package interface_adapter.bookmark;

import interface_adapter.logged_in.LoggedInViewModel;
import use_case.bookmarks.AddBookmarkOutputBoundary;
import use_case.bookmarks.BookmarkOutputData;

/**
 * Presenter for handling the output of bookmark addition operations.
 */
public class AddBookmarkPresenter implements AddBookmarkOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;

    public AddBookmarkPresenter(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
    }
    /**
     * Prepares the view when a bookmark is successfully added.
     *
     * @param outputData the output data containing information about the added bookmark and all
     *                   bookmarks associated with the user.
     */
    public void prepareSuccessView(BookmarkOutputData outputData){
        loggedInViewModel.setNotification("Added bookmark", true);
    }

    /** Prepares the view to display an error message when the addition of bookmark is not successful.
     *
     * @param errormsg the error message that will be displayed to the user.
     */
    public void prepareErrorView(String errormsg){
        loggedInViewModel.setNotification("Bookmark already exists", false);
    }
}
