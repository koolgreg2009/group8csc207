package interface_adapter.login_success;

import use_case.login_success.DisplayPetsInputBoundary;
import use_case.login_success.DisplayPetsInputData;

public class DisplayPetsController {
	private final DisplayPetsInputBoundary loginSuccessInteractor;

	public DisplayPetsController(DisplayPetsInputBoundary loginSuccessInteractor) {
		this.loginSuccessInteractor = loginSuccessInteractor;
	}

	public void execute(String userName) {
		this.loginSuccessInteractor.execute(new DisplayPetsInputData(userName));
	}
}
