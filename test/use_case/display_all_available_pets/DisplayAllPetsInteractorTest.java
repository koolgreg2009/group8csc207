package use_case.display_all_available_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.preference.UserPreference;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DisplayAllPetsInteractorIntegrationTest {

    private PetDAOInterface filePetDAO;
    private UserDAOInterface fileUserDAO;
    private DisplayAllPetsOutputBoundary displayAllPetPresenter;
    private DisplayAllPetsInteractor interactor;

    @BeforeEach
    void setUp() {
        filePetDAO = mock(PetDAOInterface.class);
        fileUserDAO = mock(UserDAOInterface.class);
        displayAllPetPresenter = mock(DisplayAllPetsOutputBoundary.class);
        interactor = new DisplayAllPetsInteractor(filePetDAO, fileUserDAO, displayAllPetPresenter);
    }

    @Test
    void testDisplayAllPetsSuccess() {
        // Given
        String username = "testUser";
        UserPreference userPreference = new UserPreference("Cat", List.of("British Shorthair"), 1, 5, "Low", "New York", "Female");
        AdopterUser user = new AdopterUser(username, "password", "Test Name", "test@example.com", "1234567890");
        user.setPreferences(userPreference);
        when(fileUserDAO.get(username)).thenReturn(user);

        Pet pet1 = new Pet("Owner1", "owner1@example.com", "1234567890", 1, "Cat", 3, "British Shorthair", List.of("Friendly"), "Male", "Low", "small cat", "new york", true);
        Pet pet2 = new Pet("Owner2", "owner2@example.com", "1234567890", 2, "Cat", 2, "British Shorthair", List.of("Playful"), "Female", "Low", "small cat", "new york", true);
        List<Pet> matchingPets = List.of(pet1, pet2);
        when(filePetDAO.getPreferencePets(userPreference)).thenReturn(new ArrayList<>(matchingPets));

        // Prepare input data
        DisplayAllPetsInputData inputData = new DisplayAllPetsInputData(username);

        // Execute the use case
        interactor.execute(inputData);

        // Verify that the pets were retrieved and passed to the presenter
        verify(fileUserDAO).get(username);
        verify(filePetDAO).getPreferencePets(userPreference);
        verify(displayAllPetPresenter).displayAllPetsOutput(any(DisplayAllPetsOutputData.class));
    }
}
