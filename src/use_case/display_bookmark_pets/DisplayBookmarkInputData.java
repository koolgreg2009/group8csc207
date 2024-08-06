package use_case.display_bookmark_pets;

import entity.Bookmark;

import java.util.List;

public class DisplayBookmarkInputData {
    private final List<Bookmark> bookmarks;
    public DisplayBookmarkInputData(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }
}
