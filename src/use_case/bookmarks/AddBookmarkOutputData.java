package use_case.bookmarks;

import entity.Bookmark;

import java.util.List;
// bookmarks is user's list of bookmarks bookmark is the bookmark added to removed
public class AddBookmarkOutputData {
    private final List<Bookmark> bookmarks;
    private final Bookmark bookmark;

    public AddBookmarkOutputData(List<Bookmark> bookmarks, Bookmark bookmark) {
        this.bookmarks = bookmarks;
        this.bookmark = bookmark;
    }
    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }
    public Bookmark getBookmark() {
        return bookmark;
    }
}
