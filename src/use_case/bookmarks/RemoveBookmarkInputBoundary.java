package use_case.bookmarks;

/** The RemoveBookmarkInputBoundary interface is an interface for handling bookmark removal operations.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface RemoveBookmarkInputBoundary {

    /**
     * Removes an existing bookmark.
     * @param bookmarkInputData the data required to remove the bookmark.
     */
    void removeBookmark(BookmarkInputData bookmarkInputData);
}
