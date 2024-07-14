package entity.User;

import entity.Bookmark;
import entity.Pet;
import entity.Preference.UserPreference;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Represents a user that is specifically classified as an adopter with bookmarks and preferences.
 * Extends {@link CommonUser} and implements {@link AdopterInterface}.
 *
 * @version 1.0
 * @since 2024-07-14
 */
public class AdopterUser extends CommonUser implements AdopterInterface {

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
	 * @param name the name of the person who the adopter user belongs too
	 * @param email the email of the adopter user
	 * @param phone the phone number of the adopter user
	 */
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
	@Override
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
	 * Adds a bookmark for the pet that was specified.
	 *
	 * @param pet the pet that is being bookmarked
	 */
	public void addBookmark(Pet pet) {

		bookmarks.add(new Bookmark(pet, LocalDateTime.now()));
	}

	/**
	 * Removes a bookmark for the pet that was specified.
	 *
	 * @param pet the pet that the bookmark belongs to that is being removed
	 */
	public void removeBookmark(Pet pet) {
		// bookmarks.remove(...)
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