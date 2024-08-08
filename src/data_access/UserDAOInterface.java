package data_access;
import entity.user.User;

import java.util.List;

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

	boolean existsByEmail(String email);

	boolean existsByPhone(String phone);

	String clearUsers();

	User get(String username);

	List<String> removePetFromAllUserBookmarks(int petID);

	boolean userHasBookmark(String username, int petID);

}
