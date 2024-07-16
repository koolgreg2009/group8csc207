package entity;
import java.time.LocalDateTime;

/** The BookmarkFactory class is a factory responsible for the creation of Bookmark
 * entities for the adopter user.
 *
 * @version 2.0
 * @since 2024-07-16
 *
 */

public class BookmarkFactory {

    /** The create method creates a Bookmark.
     * @param petID The ID of pet that is being bookmarked.
     * @param time The date and time that the bookmark is created
     * @return the newly created Bookmark.
     */
    public Bookmark create(int petID, LocalDateTime time) {
        return new Bookmark(petID, time); // return new bookmark
    }
}
