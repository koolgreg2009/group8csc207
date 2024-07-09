package entity.User;

import entity.Bookmark;
import entity.Pet;
import entity.Preference.UserPreference;

import java.util.ArrayList;
import java.util.List;

public class AdopterUser extends CommonUser implements AdopterInterface {
	private ArrayList<Bookmark> bookmarks;
	private UserPreference preferences;

	public AdopterUser(String username, String password, String name, String email, String phone) {
		super(username, password, name, email, phone);
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

	public void addBookmark(Pet pet) {
		bookmarks.add(new Bookmark());
	}

	public void removeBookmark(Pet pet) {
		// bookmarks.remove(...)
	}

	public List<Bookmark> getBookmarks() {
		return this.bookmarks;
	}
}