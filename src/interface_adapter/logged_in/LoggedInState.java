package interface_adapter.logged_in;

import java.util.ArrayList;
import java.util.List;

import dto.PetDTO;

/**
 * Represents the state of a logged-in user.
 * Maintains the username of the currently logged-in user, a list of pets, and notification details.
 */
public class LoggedInState {
    private String username = "";
    private List<PetDTO> pets = new ArrayList<>();
    private String notificationMessage;
    private boolean notificationSuccess;

    /**
     * Constructs a new {@code LoggedInState} object by copying the state from another {@code LoggedInState} instance.
     *
     * @param copy the {@code LoggedInState} instance to copy from.
     */
    public LoggedInState(LoggedInState copy) {
        username = copy.username;
    }

    /**
     * Constructs a new, empty {@code LoggedInState} object.
     */
    public LoggedInState() {}

    /**
     * Returns the username of the currently logged-in user.
     *
     * @return the username as a {@code String}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the currently logged-in user.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the list of pets associated with the logged-in user.
     *
     * @return the list of {@code PetDTO} objects representing the user's pets.
     */
	public List<PetDTO> getPets() {
		return pets;
	}

    /**
     * Sets the list of pets associated with the logged-in user.
     *
     * @param pets the list of {@code PetDTO} objects to set.
     */
	public void setPets(List<PetDTO> pets) {
		this.pets = pets;
	}

    /**
     * Returns the notification message.
     *
     * @return the notification message as a {@code String}.
     */
    public String getNotificationMessage() {
        return notificationMessage;
    }

    /**
     * Sets the notification message.
     *
     * @param notificationMessage the notification message to set.
     */
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    /**
     * Returns whether the notification was successful.
     *
     * @return {@code true} if the notification was successful, {@code false} otherwise.
     */
    public boolean isNotificationSuccess() {
        return notificationSuccess;
    }

    /**
     * Sets whether the notification was successful.
     *
     * @param notificationSuccess {@code true} if the notification was successful, {@code false} otherwise.
     */
    public void setNotificationSuccess(boolean notificationSuccess) {
        this.notificationSuccess = notificationSuccess;
    }
}
