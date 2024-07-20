package use_case.bookmarks;

/**
 * The BookmarkInputBoundary interface is an interface for handling bookmark addition operations.
 */
public interface BookmarkInputBoundary {

    /**
     * Executes the addition or removal of a bookmark based on the provided input data.
     * @param inputData the data required to add or remove the bookmark.
     */
    void execute(BookmarkInputData inputData);
}
