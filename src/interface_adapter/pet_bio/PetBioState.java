package interface_adapter.pet_bio;

import dto.pet.PetDTO;

public class PetBioState {
	private PetDTO pet;
	private String viewUser;

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

}
