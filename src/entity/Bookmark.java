package entity;
import java.time.LocalDateTime;

/** The Bookmark class creates bookmarks for the adopter to save the pets they are
 * interested in adopting.
 *
 * @author Jane Li
 * @version 1.0
 * @since 2024-07-15
 */
public class Bookmark {
    private Pet pet;
    private LocalDateTime bookmarkedDate;

    /** This is the Initializer for a bookmark.
     * @param petProfile the pet in the listing being bookmarked.
     * @param time the date and time the bookmark is created.
     */
    public Bookmark(Pet petProfile, LocalDateTime time) {
        this.pet = petProfile;
        this.bookmarkedDate = time;
    }
}
