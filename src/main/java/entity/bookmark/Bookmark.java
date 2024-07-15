package entity.bookmark;

import entity.pet.Pet;

import java.time.LocalDateTime;

public class Bookmark {
    /** Class containing bookmarks that adopter user made to save pets they are interested
     * in adopting.
    */
    private Pet pet;
    private LocalDateTime bookmarkedDate;

    public Bookmark(Pet petProfile, LocalDateTime time) {
        /** Initializer for a bookmark.
        * @param pet the pet in the listing being bookmarked.
        * @param time the date and time the bookmark is created.
        */

        this.pet = petProfile;
        this.bookmarkedDate = time;
    }
}
