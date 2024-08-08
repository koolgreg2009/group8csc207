package interface_adapter.bookmark;

import use_case.bookmarks.BookmarkOutputData;
import use_case.bookmarks.RemoveBookmarkOutputBoundary;

/**
 * Presenter for handling the output of bookmark removal operations.
 */
public class RemoveBookmarkPresenter implements RemoveBookmarkOutputBoundary {
    private final BookmarkViewModel bookmarkViewModel;

    public RemoveBookmarkPresenter(BookmarkViewModel bookmarkViewModel) {
        this.bookmarkViewModel = bookmarkViewModel;
    }

    /**
     * Prepares the view when a bookmark is successfully removed.
     *
     * @param outputData the output data containing information about the removed bookmark and all
     *                   bookmarks associated with the user.
     */
    @Override
    public void prepareSuccessView(BookmarkOutputData outputData) {
        bookmarkViewModel.setNotification("Bookmark successfully removed!", true);
    }
}
