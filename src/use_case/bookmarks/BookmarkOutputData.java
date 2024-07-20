package use_case.bookmarks;

import entity.Bookmark;

import java.util.List;

/**
 *  The BookmarkOutputData class bundles the necessary output data.
 */
public class BookmarkOutputData {
    private final List<Bookmark> allBookmarks;
    private final Bookmark bookmark;

    /**
     * Constructs a BookmarkOutputData object with the specified list of all bookmarks
     * and the specific bookmark that was removed.
     *
     * @param allBookmarks the list of all bookmarks associated with the user's profile
     * @param bookmark the specific bookmark that was removed
     */
    public BookmarkOutputData(List<Bookmark> allBookmarks, Bookmark bookmark) {
        this.allBookmarks = allBookmarks;
        this.bookmark = bookmark;
    }

    /**
     * Gets the list of all bookmarks associated with the user.
     * @return the list of all bookmarks.
     */
    public List<Bookmark> getAllBookmarks() {
        return allBookmarks;
    }

    /**
     * Gets the specific bookmark that was removed.
     * @return the specific bookmark that was removed.
     */
    public Bookmark getBookmark() {
        return bookmark;
    }
}
