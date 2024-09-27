package interface_adapter.display_pets;

import use_case.display_pets.DisplayPetsInputBoundary;
import use_case.display_pets.DisplayPetsInputData;

/**
 * The {@link DisplayPetsController} class is responsible for handling the display of pets based on user input.
 * It acts as an intermediary between the user interface and the use case for displaying pets.
 */
public class DisplayPetsController {
	private final DisplayPetsInputBoundary loginSuccessInteractor;

	/**
	 * Constructs a {@link DisplayPetsController} with the specified input boundary for displaying pets.
	 *
	 * @param loginSuccessInteractor the use case input boundary that handles the logic for displaying pets
	 */
	public DisplayPetsController(DisplayPetsInputBoundary loginSuccessInteractor) {
		this.loginSuccessInteractor = loginSuccessInteractor;
	}

	/**
	 * Executes the display pets use case with the given username.
	 * This method creates a new {@link DisplayPetsInputData} object with the provided username and passes it to the
	 * {@link DisplayPetsInputBoundary} for processing.
	 *
	 * @param userName the username of the user for whom pets are to be displayed
	 */
	public void execute(String userName) {
		this.loginSuccessInteractor.execute(new DisplayPetsInputData(userName));
	}
}
