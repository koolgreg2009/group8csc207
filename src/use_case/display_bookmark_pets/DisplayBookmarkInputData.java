package use_case.display_bookmark_pets;

import entity.Bookmark;

import java.util.List;

public class DisplayBookmarkInputData {
    private final String username;
    public DisplayBookmarkInputData(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
