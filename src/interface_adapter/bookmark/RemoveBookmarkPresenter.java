package interface_adapter.bookmark;

import interface_adapter.display_bookmark_pets.DisplayBookmarkController;
import use_case.bookmarks.BookmarkOutputData;
import use_case.bookmarks.RemoveBookmarkOutputBoundary;

/**
 * Presenter for handling the output of bookmark removal operations.
 */
public class RemoveBookmarkPresenter implements RemoveBookmarkOutputBoundary {
    private final BookmarkViewModel bookmarkViewModel;
    private final DisplayBookmarkController displayBookmarkController;

    public RemoveBookmarkPresenter(BookmarkViewModel bookmarkViewModel, DisplayBookmarkController displayBookmarkController) {
        this.bookmarkViewModel = bookmarkViewModel;
        this.displayBookmarkController = displayBookmarkController;
    }

    /**
     * Prepares the view when a bookmark is successfully removed.
     *
     * @param outputData the output data containing information about the removed bookmark and all
     *                   bookmarks associated with the user.
     */
    @Override
    public void prepareSuccessView(BookmarkOutputData outputData) {
        BookmarkState bookmarkState = bookmarkViewModel.getBookmarkState();
        bookmarkState.setBookmarkDTO(outputData.getBookmarkDTO());
        bookmarkViewModel.setNotification("Bookmark successfully removed!", true);
        // displaybookmark usecase
        displayBookmarkController.execute(outputData.getUsername());
    }
}
