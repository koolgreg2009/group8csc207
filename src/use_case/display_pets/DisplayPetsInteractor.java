package use_case.display_pets;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.PetDTO;
import entity.Pet;
import entity.user.User;

public class DisplayPetsInteractor implements DisplayPetsInputBoundary {
    final DisplayPetsOutputBoundary loginSuccessPresenter;
    final UserDAOInterface userDAO;
	final PetDAOInterface petDAO;

    public DisplayPetsInteractor(DisplayPetsOutputBoundary displayPetsOutputBoundary, UserDAOInterface userDAO, PetDAOInterface petDAO) {
        this.loginSuccessPresenter = displayPetsOutputBoundary;
        this.userDAO = userDAO;
        this.petDAO = petDAO;
    }

    @Override
    public void execute(DisplayPetsInputData loggedInInputData) {
        String userName = loggedInInputData.getUserName();
        User user = userDAO.get(userName);
		ArrayList<Pet> pets = petDAO.getAvailablePets();//.getPreferencePets(((AdopterUser)user).getPreferences());
		List<PetDTO> petDtoList = pets == null ? new ArrayList<PetDTO>()
				: pets.stream()
						.map(pet -> new PetDTO(pet.getPetID(), pet.getName(), pet.getBreed(), pet.getGender(),
								pet.getSpecies(), pet.getPetAge(), pet.getBio(), pet.getOwner(), pet.getEmail(),
								pet.getPhoneNum(), pet.getActivityLevel(), pet.getLocation(), pet.getImgUrl()))
						.collect(Collectors.toList());
		petDtoList.sort((p1, p2) -> p1.getPetID() - p2.getPetID());
		DisplayPetsOutputData displayPetsOutputData = new DisplayPetsOutputData(user.getUsername(), petDtoList);
        loginSuccessPresenter.prepareLoggedIn(displayPetsOutputData);
    }
}
