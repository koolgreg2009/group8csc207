package entity;

import java.time.LocalDateTime;

public class BookmarkFactory {
    /** Factory that creates bookmarks for the user to use.
     */

    public Bookmark create(int petID, LocalDateTime time) {
        /** Method that creates a bookmark
         */
        return new Bookmark(petID, time); // return new bookmark
    }
}
