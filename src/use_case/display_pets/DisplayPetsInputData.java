package use_case.display_pets;

/**
 * Data transfer object containing the input data required for the
 * display pets use case.
 * <p>
 * This class encapsulates the information needed to execute the use case
 * for displaying pets, specifically the username of the user requesting
 * the display of pets.
 * </p>
 */
public class DisplayPetsInputData {
	private String userName;

	/**
	 * Constructs a new DisplayPetsInputData with the specified username.
	 *
	 * @param userName the username of the user requesting to display pets
	 */
	public DisplayPetsInputData(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the username associated with the display pets request.
	 *
	 * @return the username of the user
	 */
	public String getUserName() {
		return userName;
	}
}
