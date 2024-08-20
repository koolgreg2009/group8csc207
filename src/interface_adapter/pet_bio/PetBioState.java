package interface_adapter.pet_bio;

import dto.PetDTO;

/**
 * Represents the state of the pet biography view.
 * Holds information about the pet, the user viewing the pet's biography, and any notifications.
 */
public class PetBioState {
	private PetDTO pet;
	private String viewUser;
	private String notification;

	/**
	 * Gets the {@code PetDTO} representing the pet's details.
	 *
	 * @return the {@code PetDTO} with pet information.
	 */
	public PetDTO getPet() {
		return pet;
	}

	/**
	 * Sets the {@code PetDTO} representing the pet's details.
	 *
	 * @param pet the {@code PetDTO} to set.
	 */
	public void setPet(PetDTO pet) {
		this.pet = pet;
	}

	/**
	 * Gets the username of the user viewing the pet's biography.
	 *
	 * @return the username of the viewer.
	 */
	public String getViewUser() {
		return viewUser;
	}

	/**
	 * Sets the username of the user viewing the pet's biography.
	 *
	 * @param viewUser the username of the viewer.
	 */
	public void setViewUser(String viewUser) {
		this.viewUser = viewUser;
	}

	/**
	 * Sets the notification message related to the pet's biography.
	 *
	 * @param notification the notification message to set.
	 */
	public void setNotification(String notification) {
		this.notification = notification;
	}

	/**
	 * Gets the notification message related to the pet's biography.
	 *
	 * @return the notification message.
	 */
	public String getNotification() {
		return notification;
	}
}
