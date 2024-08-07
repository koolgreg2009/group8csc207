package interface_adapter.display_pets;

import use_case.display_pets.DisplayPetsInputBoundary;
import use_case.display_pets.DisplayPetsInputData;

public class DisplayPetsController {
	private final DisplayPetsInputBoundary loginSuccessInteractor;

	public DisplayPetsController(DisplayPetsInputBoundary loginSuccessInteractor) {
		this.loginSuccessInteractor = loginSuccessInteractor;
	}

	public void execute(String userName) {
		this.loginSuccessInteractor.execute(new DisplayPetsInputData(userName));
	}
}
