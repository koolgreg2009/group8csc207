package use_case.display_pets;

import java.util.List;
import dto.PetDTO;

/**
 * Output data for displaying pets.
 * <p>
 * This class encapsulates the data required to display pets to the user, including the username and a list of pet data transfer objects (DTOs).
 * It is used to transfer data from the interactor to the presenter or view responsible for rendering the pet information.
 * </p>
 */
public class DisplayPetsOutputData {
	private final String username;
	private final List<PetDTO> pets;

	/**
	 * Constructs a new DisplayPetsOutputData instance with the specified username and list of pet DTOs.
	 *
	 * @param username the username of the user whose pets are being displayed
	 * @param petDtoList the list of pet DTOs to be displayed
	 */
	public DisplayPetsOutputData(String username, List<PetDTO> petDtoList) {
		this.username = username;
		this.pets = petDtoList;
	}

	/**
	 * Gets the username associated with the displayed pets.
	 *
	 * @return the username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the list of pet DTOs to be displayed.
	 *
	 * @return the list of pet DTOs
	 */
	public List<PetDTO> getPets() {
		return pets;
	}
}
