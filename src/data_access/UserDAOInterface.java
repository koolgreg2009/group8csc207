package data_access;
import entity.user.User;

import java.util.List;

public interface UserDAOInterface {
    void save(User user);
    boolean existsByName(String identifier);
	String clearUsers();
	User get(String username);
	List<String> removePetFromAllUserBookmarks(int petID);
	boolean userHasBookmark(String username, int petID);
}
