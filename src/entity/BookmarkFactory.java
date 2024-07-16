package entity;

import java.time.LocalDateTime;

public class BookmarkFactory {
    /** Factory that creates bookmarks for the user to use.
     */

    public Bookmark create(Pet pet, LocalDateTime time) {
        /** Method that creates a bookmark
         */
        return new Bookmark(pet.getPetID(), time); // return new bookmark
    }
}
