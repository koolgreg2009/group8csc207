package entity;

import entity.User.AdopterUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkFactory implements BookmarkFactoryInterface {
    /** Bookmarks that user made to save pets they are interested in adopting.
     * @param pet the pet in the listing being bookmarked.
     * @param time the date and time the bookmark is created.
     */

    public BookmarkInterface create(Pet pet, LocalDateTime time) {
        return new Bookmark(pet, time);
    }
}
