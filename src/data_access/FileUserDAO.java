package data_access;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.user.AdopterUser;
import entity.user.User;

/**
 * The FileUserDAO class provides an implementation for managing user data stored in a JSON file.
 * It supports loading, saving, and modifying user data, including operations for user bookmarks.
 * This class implements the UserDAOInterface to define the behavior for user data access.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class FileUserDAO implements UserDAOInterface {

	/** The file used for storing user data in JSON format. */
	private final File jsonFile;

	/** A map of usernames to user objects for in-memory user data management. */
	private final Map<String, AdopterUser> accounts = new HashMap<String, AdopterUser>();

	/**
	 * Constructs a new FileUserDAO with the specified JSON file path.
	 * Initializes the user data from the file or creates a new file if it is empty.
	 *
	 * @param jsonPath
	 */
	public FileUserDAO(String jsonPath) throws IOException {
		jsonFile = new File(jsonPath);
		if (jsonFile.length() == 0) {
			save();
		} else {
			TypeReference<HashMap<String, AdopterUser>> typeRef = new TypeReference<HashMap<String, AdopterUser>>() {
			};
			ObjectMapper objectMapper = new ObjectMapper();
			accounts.putAll(objectMapper.readValue(jsonFile, typeRef));
		}
	}

	/**
	 * Saves the specified user to the JSON file.
	 * Updates the in-memory user map and writes the changes to the file.
	 *
	 * @param user
	 */
	@Override
	public void save(User user) {
		accounts.put(user.getUsername(), (AdopterUser) user);
		this.save();
	}

	/**
	 * Retrieves the user with the specified username.
	 *
	 * @param username
	 * @return The user associated with the specified username, or null if not found.
	 */
	@Override
	public User get(String username) {
		return accounts.get(username);
	}

	/**
	 * Saves the current state of user data to the JSON file.
	 * This method is called to persist changes made to the in-memory user map.
	 */
	private void save() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(jsonFile, accounts);
		} catch (Exception ex) {
			System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Checks if a user with the specified identifier exists in the system.
	 *
	 * @param identifier
	 * @return true if a user with the specified identifier exists; false otherwise.
	 */
	@Override
	public boolean existsByName(String identifier) {
		return accounts.containsKey(identifier);
	}

	/**
	 * Clears all user data from the JSON file and returns a string containing the names of all cleared users.
	 *
	 * @return A string containing the names of all users that were cleared.
	 */
	@Override
	public String clearUsers() { //

		try {
			RandomAccessFile file = new RandomAccessFile(jsonFile, "rw");
			file.setLength(0);
			file.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		StringBuilder empty = new StringBuilder(new String(""));
		for (User user : accounts.values()) {
			empty.append(user.getName()).append("\n");
		}
		accounts.clear();
		return empty.toString();
	}

	/**
	 * Removes a pet from all user bookmarks and returns a list of usernames whose bookmarks were updated.
	 *
	 * @param petID
	 * @return A list of usernames whose bookmarks were updated.
	 */
	@Override
	public List<String> removePetFromAllUserBookmarks(int petID) {
		List<String> usersNotified = new ArrayList<>();
		accounts.entrySet().stream()
				.filter(a -> a.getValue().getBookmarks().stream().anyMatch(l -> l.getPetID() == petID))
				.forEach(entry -> {entry.getValue().getBookmarks().removeIf(b -> b.getPetID() == petID);
				usersNotified.add(entry.getKey());
				});
		save();
		return usersNotified;
	}

	/**
	 * Checks if a user has bookmarked a pet with the specified ID.
	 *
	 * @param username The username of the user to check.
	 * @param petID The ID of the pet to check for in the user's bookmarks.
	 * @return true if the user has bookmarked the pet; false otherwise.
	 */
	@Override
	public boolean userHasBookmark(String username, int petID) {
		AdopterUser user = accounts.get(username);
		if (user != null) {
			return user.getBookmarks().stream().anyMatch(bookmark -> bookmark.getPetID() == petID);
		}
		return false;
	}

}
