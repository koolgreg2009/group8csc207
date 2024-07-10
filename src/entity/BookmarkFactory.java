package entity;

import entity.User.AdopterUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkFactory implements BookmarkFactoryInterface {
    /** Bookmarks that user made to save pets they are interested in adopting.
     */
    private Pet pet;
    private LocalDateTime bookmarkedDate;
    private AdopterUser bookmarkUser;

    public BookmarkFactory(Pet petProfile, LocalDateTime time, AdopterUser user) {
        this.pet = petProfile;
        this.bookmarkedDate = time;
        this.bookmarkUser = user;
    }

    public void createBookMark(Pet pet){
        /** Method to create a new individual bookmark.
         * @param pet the pet that is to be bookmarked
         * @param bookmarkedDate the date and time that pet is bookmarked
         */
        List<Object> bookmark = new ArrayList<>(3);
        bookmark.add(pet);
        bookmark.add(this.bookmarkedDate);
        bookmark.add(this.bookmarkUser);
    }
}
