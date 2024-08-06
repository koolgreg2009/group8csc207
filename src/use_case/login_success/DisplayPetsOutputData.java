package use_case.login_success;

import java.util.List;

import dto.pet.PetDTO;

public class DisplayPetsOutputData {
	private final String username;
	private final List<PetDTO> pets;

	public DisplayPetsOutputData(String username, List<PetDTO> petDtoList) {
		this.username = username;
		this.pets = petDtoList;
	}

	public String getUsername() {
		return username;
	}

	public List<PetDTO> getPets() {
		return pets;
	}
}
