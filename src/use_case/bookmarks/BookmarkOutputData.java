package use_case.bookmarks;

import dto.BookmarkDTO;
import entity.Bookmark;
import java.util.List;

/**
 *  The BookmarkOutputData class bundles the necessary output data.
 */
public class BookmarkOutputData {
    private final List<Bookmark> allBookmarks;
    private final Bookmark bookmark;
    private final List<BookmarkDTO> bookmarkDTO;
    private final String username;

    /**
     * Constructs a BookmarkOutputData object with the specified list of all bookmarks
     * and the specific bookmark that was removed.
     *
     * @param allBookmarks the list of all bookmarks associated with the user's profile
     * @param bookmark     the specific bookmark that was removed
     * @param bookmarkDTO
     */
    public BookmarkOutputData(List<Bookmark> allBookmarks, Bookmark bookmark, List<BookmarkDTO> bookmarkDTO, String username) {
        this.allBookmarks = allBookmarks;
        this.bookmark = bookmark;
        this.bookmarkDTO = bookmarkDTO;
        this.username = username;
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

    /**
     * Get the specific bookmarkDTO
     * @return the bookmarkDTO
     */
    public List<BookmarkDTO> getBookmarkDTO() {return bookmarkDTO;}
    public String getUsername() {
        return username;
    }
}
