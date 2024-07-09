package entity.User;

import entity.Bookmark;
import entity.Pet;
import entity.Preference.UserPreference;

import java.util.List;

public interface AdopterInterface extends User {

    void setPreferences(UserPreference newPreference);
    UserPreference getPreferences();
    void addBookmark(Pet pet);
    void removeBookmark(Pet pet);
    List<Bookmark> getBookmarks();
}
