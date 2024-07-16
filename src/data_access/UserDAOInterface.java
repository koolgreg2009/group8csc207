package data_access;
import entity.User.User;

public interface UserDAOInterface {
    void save(User user);
    boolean existsByName(String identifier);
	String clearUsers();
	User get(String username);
	void removePetFromAllUserBookmarks(int petID);
}
