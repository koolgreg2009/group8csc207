package entity.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import entity.Bookmark;
import entity.preference.UserPreference;

/**
 * Represents a user that is specifically classified as an adopter with
 * bookmarks and preferences. Extends {@link CommonUser} and implements
 *
 * @version 1.0
 * @since 2024-07-12
 */
public class AdopterUser extends CommonUser{

	/**
	 * List of bookmarks that the adopter user has.
	 */
	private ArrayList<Bookmark> bookmarks;

	/**
	 * Adopter user's pet preferences
	 */
	private UserPreference preferences;

	/**
	 * Constructs a new AdopterUser with these parameters.
	 *
	 * @param username the username of the adopter user
	 * @param password the password of the adopter user
	 * @param name     the name of the person who the adopter user belongs too
	 * @param email    the email of the adopter user
	 * @param phone    the phone number of the adopter user
	 *
	 */
	@JsonCreator()
	public AdopterUser(@JsonProperty("userId") long userId, @JsonProperty("username") String username,
			@JsonProperty("password") String password, @JsonProperty("name") String name,
			@JsonProperty("email") String email, @JsonProperty("phone") String phone,
			@JsonProperty("bookmarks") ArrayList<Bookmark> bookmarks,
			@JsonProperty("preferences") UserPreference preferences) {
		super(userId, username, password, name, email, phone);
		this.bookmarks = bookmarks;
		this.preferences = preferences;
	}

	public AdopterUser(String username, String password, String name, String email, String phone) {
		super(username, password, name, email, phone);
		this.bookmarks = new ArrayList<>();
		this.preferences = new UserPreference();
	}

	/**
	 * Gets the preferences of the adopter user.
	 *
	 * @return the preferences of the adopter user
	 */
	public UserPreference getPreferences() {
		return preferences;
	}

	/**
	 * Sets the preferences of the adopter user.
	 *
	 * @param preferences the preferences of the adopter user
	 */
	public void setPreferences(UserPreference preferences) {
		this.preferences = preferences;
	}

	/**
	 * Adds the specified bookmark to the adopter user.
	 *
	 * @param bookmark the bookmark being added to the adopter user
	 */
	public void addBookmark(Bookmark bookmark) {
//		LocalDateTime now = LocalDateTime.now();
//		BookmarkFactory bookmarkFactory = new BookmarkFactory();
//		bookmarks.add(bookmarkFactory.create(pet, now));
		// the core entity (User or Pet, depending on the context) should not be
		// responsible for creating new objects
		// (e.g., via a factory) or knowing about the current time
		// addBookmark(Pet pet) should be in the use case layer, as it involves
		// application-specific logic and
		// dependencies that should not be part of the core business entitie
		bookmarks.add(bookmark);
	}

	/**
	 * Removes the specified bookmark from the adopter user.
	 *
	 * @param bookmark the bookmark that is being removed from the adopter user
	 */
	public void removeBookmark(Bookmark bookmark) {
		bookmarks.remove(bookmark);
	}

	/**
	 * Gets list of the bookmarks associated with the adopter user.
	 *
	 * @return a list of bookmarks
	 */
	public List<Bookmark> getBookmarks() {
		return this.bookmarks;
	}
}