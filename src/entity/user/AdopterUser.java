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
	 * Constructs an {@code AdopterUser} object using the specified JSON properties.
	 *
	 * <p>This constructor is used for deserialization from JSON. It initializes an `AdopterUser`
	 * with the provided username, password, name, email, phone number, a list of bookmarks,
	 * and user preferences.
	 *
	 * @param username the username of the adopter user
	 * @param password the password of the adopter user
	 * @param name the full name of the adopter user
	 * @param email the email address of the adopter user
	 * @param phone the phone number of the adopter user
	 * @param bookmarks a list of bookmarks associated with the adopter user
	 * @param preferences the user preferences associated with the adopter user
	 */
	@JsonCreator()
	public AdopterUser(@JsonProperty("username") String username,
			@JsonProperty("password") String password, @JsonProperty("name") String name,
			@JsonProperty("email") String email, @JsonProperty("phone") String phone,
			@JsonProperty("bookmarks") ArrayList<Bookmark> bookmarks,
			@JsonProperty("preferences") UserPreference preferences) {
		super(username, password, name, email, phone);
		this.bookmarks = bookmarks;
		this.preferences = preferences;
	}

	/**
	 * Constructs an {@code AdopterUser} object with the specified details.
	 *
	 * <p>This constructor initializes an `AdopterUser` with the provided username, password,
	 * name, email, and phone number. It also initializes an empty list of bookmarks and
	 * a new `UserPreference` object with default values.
	 *
	 * @param username the username of the adopter user
	 * @param password the password of the adopter user
	 * @param name the full name of the adopter user
	 * @param email the email address of the adopter user
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

	/**
	 * Returns a string representation of the current object.
	 * <p>
	 * This method provides a string that includes the class name,
	 * the result of the superclass's `toString` method, and details about
	 * the bookmarks and preferences associated with this object.
	 *
	 * @return a string representation of the object, including class name,
	 *         superclass's string representation, and the bookmarks and
	 *         preferences
	 */
	@Override
	public String toString(){
		return this.getClass()+": " + super.toString() + "\nBookmarks: " + bookmarks + "\nPreferences: " + preferences;
	}
}