package use_case.display_bookmark_pets;

/**
 * Represents the input data required for displaying bookmarked pets.
 * <p>
 * This class encapsulates the information needed to retrieve and display the list of pets
 * that have been bookmarked by a specific user.
 * </p>
 */
public class DisplayBookmarkInputData {
    private final String username;

    /**
     * Constructs a new instance of DisplayBookmarkInputData with the specified username.
     *
     * @param username the username of the user whose bookmarked pets are to be displayed
     */
    public DisplayBookmarkInputData(String username) {
        this.username = username;
    }

    /**
     * Gets the username associated with the input data.
     *
     * @return the username of the user whose bookmarked pets are to be displayed
     */
    public String getUsername() {
        return username;
    }
}
