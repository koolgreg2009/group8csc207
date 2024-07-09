package entity;

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

    public void createBookMark(Pet pet, LocalDateTime bookmarkedDate){
        /** Method to create a new individual bookmark.
         * @param pet the pet that is to be bookmarked
         * @param bookmarkedDate the date and time that pet is bookmarked
         */
        List<Object> bookmark = new ArrayList<>(2);
        bookmark.add(pet);
        bookmark.add(bookmarkedDate);
    }
}
