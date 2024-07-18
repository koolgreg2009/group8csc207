package data_access;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.User.AdopterUser;
import entity.User.User;

public class FileUserDAO implements UserDAOInterface {

	private final File jsonFile;

	private final Map<String, AdopterUser> accounts = new HashMap<String, AdopterUser>();

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

	@Override
	public void save(User user) {
		accounts.put(user.getUsername(), (AdopterUser) user);
		this.save();
	}

	@Override
	public User get(String username) {
		return accounts.get(username);
	}

	private void save() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(jsonFile, accounts);
		} catch (Exception ex) {
			System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	@Override
	public boolean existsByName(String identifier) {
		return accounts.containsKey(identifier);
	}

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

	@Override
	public void removePetFromAllUserBookmarks(int petID) {
		accounts.entrySet().stream()
				.filter(a -> a.getValue().getBookmarks().stream().anyMatch(l -> l.getPetID() == petID))
				.forEach(entry -> entry.getValue().getBookmarks().removeIf(b -> b.getPetID() == petID));
		save();
	}

	public boolean userHasBookmark(String username, int petID) {
		AdopterUser user = accounts.get(username);
		if (user != null) {
			return user.getBookmarks().stream().anyMatch(bookmark -> bookmark.getPetID() == petID);
		}
		return false;
	}

}
