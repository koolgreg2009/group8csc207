package use_case.bookmarks;

import entity.Bookmark;

import java.util.List;
// bookmarks is user's list of bookmarks bookmark is the bookmark added to removed
public class BookmarkOutputData {
    private final List<Bookmark> allBookmarks;
    private final Bookmark bookmark;

    public BookmarkOutputData(List<Bookmark> allBookmarks, Bookmark bookmark) {
        this.allBookmarks = allBookmarks;
        this.bookmark = bookmark;
    }
    public List<Bookmark> getBookmarks() {
        return allBookmarks;
    }
    public Bookmark getBookmark() {
        return bookmark;
    }
}
