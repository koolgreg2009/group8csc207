package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class AdopterUser implements AdopterInterface{
    private final long userId;
    private String username;
    private String password;
    private Profile profile;
    private ArrayList<Bookmark> bookmarks;
    private UserPreference preferences;


    public AdopterUser(long userId, String username, String password, Profile profile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.bookmarks = new ArrayList<>();
        this.preferences = new UserPreference();
    }
    @Override
    public UserPreference getPreferences() {
        return preferences;
    }
    public void setPreferences(UserPreference preferences) {
        this.preferences = preferences;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public ArrayList<Bookmark> getBookmarks() {

    }
    public boolean addBookmark(Pet pet) {

    }
    public boolean removeBookmark(Pet pet) {

    }
    public List<Bookmark> getBookmarks() {
        return this.bookmarks.
    }
}