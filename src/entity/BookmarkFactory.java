package entity;
import java.time.LocalDateTime;

/** The BookmarkFactory class is a factory responsible for the creation of Bookmark
 * entities for the adopter user.
 *
 * @author Jane Li
 * @version 1.0
 * @since 2024-07-15
 *
 */

public class BookmarkFactory {

    /** The create method creates a Bookmark.
     * @param pet The pet that is being bookmarked.
     * @param time The date and time that the bookmark is created
     * @return the newly created Bookmark.
     */
    public Bookmark create(Pet pet, LocalDateTime time) {
        return new Bookmark(pet, time); // return new bookmark
    }
}
