package entity;

import entity.User.AdopterUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bookmark implements BookmarkInterface {
    /** Bookmarks that user made to save pets they are interested in adopting.
    */
    private Pet pet;
    private LocalDateTime bookmarkedDate;

    public Bookmark(Pet petProfile, LocalDateTime time) {
        this.pet = petProfile;
        this.bookmarkedDate = time;
    }
}
