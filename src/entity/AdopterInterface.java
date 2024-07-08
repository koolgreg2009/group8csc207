package entity;

import java.util.List;

public interface AdopterInterface extends User {

    void setPreferences(UserPreference newPreference);
    UserPreference getPreferences();
    boolean addBookmark(Pet pet);
    boolean removeBookmark(Pet pet);
    List<Bookmark> getBookmarks();
}
