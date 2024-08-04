package interface_adapter.pet_bio;

import dto.pet.PetDTO;

public class PetBioState {
	private PetDTO pet;

	public PetDTO getPet() {
		return pet;
	}

	public void setPet(PetDTO pet) {
		this.pet = pet;
	}

}
