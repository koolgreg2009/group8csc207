package use_case.bookmarks;

/**
 * Interface for handling the output of bookmark removal operations.
 */

public interface RemoveBookmarkOutputBoundary {
    /**
     * Processes a success message when a bookmark is successfully removed.
     * @param bookmarkOutputData the output data containing information about the removed bookmark
     */
    void successMessage(BookmarkOutputData bookmarkOutputData);
}
