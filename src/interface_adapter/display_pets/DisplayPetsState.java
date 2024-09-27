package interface_adapter.display_pets;

/**
 * Represents the state for displaying pets in the user interface.
 * Stores the username associated with the current session or context.
 */
public class DisplayPetsState {
    private String username = "";

	/**
	 * Gets the username associated with this state.
	 *
	 * @return the username as a {@code String}.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username associated with this state.
	 *
	 * @param username the username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
