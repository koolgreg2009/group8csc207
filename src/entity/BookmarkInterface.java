package entity;

import java.time.LocalDateTime;

public interface BookmarkInterface {
    /** Interface for Bookmark class
     * @param pet the pet that is to be bookmarked
     * @param bookmarkedDate the date and time that pet is bookmarked
     */
    void createBookMark(Pet pet, LocalDateTime bookmarkedDate); // To create new bookmark
}
