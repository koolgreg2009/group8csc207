package entity;

import entity.User.AdopterUser;

import java.time.LocalDateTime;

public interface BookmarkFactoryInterface{
    /** Interface for Bookmark class
     */
    BookmarkInterface create(Pet pet, LocalDateTime time);
}
