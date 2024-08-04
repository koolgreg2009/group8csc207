package use_case.login;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.pet.PetDTO;
import entity.Pet;
import entity.user.AdopterUser;
import entity.user.User;

/**
 * The LoginInteractor class implements the LoginInputBoundary interface and handles the login process.
 * It validates the login data, checks if the user exists, and verifies the password.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginInteractor implements LoginInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;
	final private PetDAOInterface petDAO;

    /**
     * Constructs a new LoginInteractor with the specified dependencies.
     *
     * @param userDataAccessInterface
     * @param petDAO 
     * @param loginOutputBoundary
     */
    public LoginInteractor(UserDAOInterface userDataAccessInterface,
                           PetDAOInterface petDAO, LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
        this.petDAO = petDAO;
    }

    /**
     * Executes the login process with the given input data.
     * Validates the data, checks if the user exists, and verifies the password.
     *
     * @param loginInputData
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("The account '" + username+"' does not exist.");
        } else {
            User user = userDataAccessObject.get(username);
			String pwd = user.getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
				ArrayList<Pet> pets = petDAO.getPreferencePets(((AdopterUser)user).getPreferences());
				List<PetDTO> petDtoList = pets == null ? new ArrayList<PetDTO>()
						: pets.stream()
								.map(pet -> new PetDTO(pet.getPetID(), pet.getName(), pet.getBreed(), pet.getGender(),
										pet.getSpecies(), pet.getPetAge(), pet.getBio(), pet.getOwner(), pet.getEmail(),
										pet.getPhoneNum(), pet.getActivityLevel(), pet.getLocation(), pet.getImgUrl()))
								.collect(Collectors.toList());
				petDtoList.sort((p1, p2) -> p1.getPetID() - p2.getPetID());
				LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), petDtoList);
				loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}