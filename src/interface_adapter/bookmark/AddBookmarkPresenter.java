package interface_adapter.bookmark;

import use_case.bookmarks.AddBookmarkOutputBoundary;
import use_case.bookmarks.BookmarkOutputData;

/**
 * Presenter for handling the output of bookmark addition operations.
 */
public class AddBookmarkPresenter implements AddBookmarkOutputBoundary {

    /**
     * Prepares the view when a bookmark is successfully added.
     *
     * @param outputData the output data containing information about the added bookmark and all
     *                   bookmarks associated with the user.
     */
    public void prepareSuccessView(BookmarkOutputData outputData){
        System.out.println(outputData.getBookmark()+" has been added. Here are all your bookmarks: "
                + outputData.getAllBookmarks());
    }

    /** Prepares the view to display an error message when the addition of bookmark is not successful.
     *
     * @param errormsg the error message that will be displayed to the user.
     */
    public void prepareErrorView(String errormsg){
        System.out.println(errormsg);
    }
}
