package entity;

import entity.bookmark.Bookmark;
import entity.preference.UserPreference;
import entity.user.CommonUser;

import java.time.LocalDateTime;
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

	public void addBookmark(Bookmark bookmark) {
//		LocalDateTime now = LocalDateTime.now();
//		BookmarkFactory bookmarkFactory = new BookmarkFactory();
//		bookmarks.add(bookmarkFactory.create(pet, now));
		// the core entity (User or Pet, depending on the context) should not be responsible for creating new objects
		// (e.g., via a factory) or knowing about the current time
		// addBookmark(Pet pet) should be in the use case layer, as it involves application-specific logic and
		// dependencies that should not be part of the core business entitie
		bookmarks.add(bookmark);
	}

	public void removeBookmark(Bookmark bookmark) {
		bookmarks.remove(bookmark);
	}

	public List<Bookmark> getBookmarks() {
		return this.bookmarks;
	}
}