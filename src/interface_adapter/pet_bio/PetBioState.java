package interface_adapter.pet_bio;

import dto.PetDTO;

public class PetBioState {
	private PetDTO pet;
	private String viewUser;
	private String notification;


	public PetDTO getPet() {
		return pet;
	}

	public void setPet(PetDTO pet) {
		this.pet = pet;
	}

	public String getViewUser() {
		return viewUser;
	}

	public void setViewUser(String viewUser) {
		this.viewUser = viewUser;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getNotification() {
		return notification;
	}
}
