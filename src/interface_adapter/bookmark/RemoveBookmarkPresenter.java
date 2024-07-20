package interface_adapter.bookmark;

import use_case.bookmarks.BookmarkOutputData;
import use_case.bookmarks.RemoveBookmarkOutputBoundary;

/**
 * Presenter for handling the output of bookmark removal operations.
 */
public class RemoveBookmarkPresenter implements RemoveBookmarkOutputBoundary {
    /**
     * Prepares the view when a bookmark is successfully removed.
     *
     * @param outputData the output data containing information about the removed bookmark and all
     *                   bookmarks associated with the user.
     */
    public void successMessage (BookmarkOutputData outputData){
        System.out.println(outputData.getBookmark() + " has been successfully removed.");
        System.out.println("Here are all your bookmarks: " + outputData.getAllBookmarks());
    }
}
