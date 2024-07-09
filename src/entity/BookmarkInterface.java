package entity;

import entity.User.AdopterUserFactory;

import java.time.LocalDateTime;

public interface BookmarkInterface {
    /** Interface for Bookmark class
     * @param pet
     * @param bookmarkedDate
     */
    void createBookMark(Pet pet, LocalDateTime bookmarkedDate); // To create new bookmark
}
