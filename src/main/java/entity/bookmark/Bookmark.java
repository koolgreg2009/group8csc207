package entity.bookmark;

import entity.pet.Pet;

import java.time.LocalDateTime;

/** Class containing bookmarks that adopter user made to save pets they are interested
 * in adopting.
 *
 * @version 1.0
 * @since 2024-07-14
 */
public class Bookmark {

    /**
     * The pet the bookmark is made for.
     */
    private Pet pet;

    /**
     * The date and time when the pet was bookmarked.
     */
    private LocalDateTime bookmarkedDate;

    /** Initializer for a bookmark.
     *
     * @param petProfile the pet in the listing being bookmarked.
     * @param time the date and time the bookmark is created.
     */
    public Bookmark(Pet petProfile, LocalDateTime time) {

        this.pet = petProfile;
        this.bookmarkedDate = time;
    }
}