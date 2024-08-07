package use_case.display_pets;

import java.util.List;

import dto.PetDTO;

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
