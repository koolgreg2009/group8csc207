package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.AdopterUserFactory;

import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {

    final UserDAOInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final AdopterUserFactory AdopterUserFactory;

    public SignupInteractor(UserDAOInterface userSignupDAInterface, SignupOutputBoundary signupOutputBoundary,  AdopterUserFactory AdopterUserFactory) {
        this.userDataAccessObject = userSignupDAInterface;
        this.userPresenter = signupOutputBoundary;
        this.AdopterUserFactory = AdopterUserFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            AdopterUser user = AdopterUserFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getName(), signupInputData.getEmail(), signupInputData.getPhone());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }

}