package entity;

import entity.Bookmark;
import entity.Profile;
import entity.UserPreference;

import java.util.ArrayList;

public class User {
    private final String userId;
    private String username;
    private String password;
    private Profile profile;
    private ArrayList<Bookmark> bookmarks;
    private UserPreference preferences;


    public User(String userId, String username, String password, Profile profile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.bookmarks = new ArrayList<>();
        this.preferences = new UserPreference();
    }
    public Object[] getUserInfo(){
        return new Object[]{userId, username, password, profile.getName(), profile.getEmail(), profile.getPhonenumber()};
    }
    public UserPreference getPreferences() {
        return preferences;
    }
    public void setPreferences(UserPreference preferences) {
        this.preferences = preferences;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public ArrayList<Bookmark> getBookmarks() {

    }
    public void addBookmark(Bookmark bookmark) {

    }
    public void removeBookmark(Bookmark bookmark) {

    }
    public ArrayList<Bookmark> getBookmarks() {
        return this.bookmarks.
    }
    public Adoption adopt(User user, Pet pet){

    }

}

