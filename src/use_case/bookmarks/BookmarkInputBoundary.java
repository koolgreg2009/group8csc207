package use_case.bookmarks;

/** The BookmarkInputBoundary interface is an interface for handling bookmark addition operations.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface BookmarkInputBoundary {

    /** Adds a new bookmark.
     * @param inputData the data required to add the bookmark.
     */
    void addBookmark(BookmarkInputData inputData);
}
