package entity;

import entity.User.AdopterUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkFactory {
    /** Factory that creates bookmarks for the user to use.
     */

    public Bookmark create(Pet pet, LocalDateTime time) {
        /** Method that creates a bookmark
         */
        return new Bookmark(pet, time); // return new bookmark
    }
}
