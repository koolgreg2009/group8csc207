package use_case.bookmarks;

/**
 * Interface for handling the output of bookmark addition operations.
 */
public interface AddBookmarkOutputBoundary {
    /**
     * Processes the view and message printed when a bookmark is successfully added.
     * @param outputdata the output data containing information about the added bookmark
     */
    void prepareSuccessView(BookmarkOutputData outputdata);

    /**
     * Processes the view and message printed when a bookmark is not successfully added.
     * @param errormsg the message displayed to show that a bookmark is not successfully added.
     */
    void prepareErrorView(String errormsg);
}
