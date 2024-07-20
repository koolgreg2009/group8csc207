package use_case.bookmarks;

/** The BookmarkInputBoundary interface is an interface for handling bookmark addition operations.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface BookmarkInputBoundary {

    /** Executes the addition or removal of a bookmark based on the provided input data.
     * @param inputData the data required to add or remove the bookmark.
     */
    void execute(BookmarkInputData inputData);
}
