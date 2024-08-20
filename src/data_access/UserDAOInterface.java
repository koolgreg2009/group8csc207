package data_access;
import entity.user.User;

import java.util.List;

/**
 * The UserDAOInterface provides the necessary methods for interacting with
 * the data source containing user information. This interface defines
 * methods for saving users, checking for user existence, retrieving user
 * information, and managing user bookmarks.
 *
 */
public interface UserDAOInterface {

	/**
	 * Saves the specified user to the data source.
	 *
	 * @param user The user to be saved.
	 */
	void save(User user);

	/**
	 * Checks if a user with the specified identifier (username) already exists in the data source.
	 *
	 * @param identifier
	 * @return true if a user with the specified username exists, false otherwise.
	 */
	boolean existsByName(String identifier);

	/**
	 * Checks if a user with the specified email already exists in the data source.
	 *
	 * @param email
	 * @return true if a user with the specified email exists, false otherwise.
	 */
	boolean existsByEmail(String email);

	/**
	 * Checks if a user with the specified phone number already exists in the data source.
	 *
	 * @param phone
	 * @return true if a user with the specified phone number exists, false otherwise.
	 */
	boolean existsByPhone(String phone);

	/**
	 * Clears all users from the data source.
	 *
	 * @return A string listing the names of all users that were removed, each on a new line.
	 */
	String clearUsers();

	/**
	 * Retrieves the user with the specified username.
	 *
	 * @param username
	 * @return The user associated with the specified username, or null if not found.
	 */
	User get(String username);

	/**
	 * Removes a pet from all user bookmarks and returns a list of usernames whose bookmarks were updated.
	 *
	 * @param petID
	 * @return A list of usernames whose bookmarks were updated.
	 */
	List<String> removePetFromAllUserBookmarks(int petID);

	/**
	 * Checks if a user has bookmarked a pet with the specified ID.
	 *
	 * @param username
	 * @param petID
	 * @return true if the user has bookmarked the pet, false otherwise.
	 */
	boolean userHasBookmark(String username, int petID);

}
