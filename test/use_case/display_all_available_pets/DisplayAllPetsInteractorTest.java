package use_case.display_all_available_pets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import data_access.UserDAOInterface;
import entity.preference.UserPreference;
import entity.user.AdopterUser;
import entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import data_access.PetDAOInterface;
import entity.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Unit test for DisplayAllAvailablePets
 */
@ExtendWith(MockitoExtension.class)
public class DisplayAllPetsInteractorTest {

    @Mock
    private DisplayAllPetsOutputBoundary mockPresenter;

    @Mock
    private PetDAOInterface mockPetDAO;

    @Mock
    private UserDAOInterface mockUserDAO;

    private DisplayAllPetsInteractor interactor;

    @BeforeEach
    public void setUp() {interactor = new DisplayAllPetsInteractor(mockPetDAO, mockUserDAO, mockPresenter);}

    @Test
    public void displayAllPets() {
        DisplayAllPetsInputData input = new DisplayAllPetsInputData("jenny");
        UserPreference userPreference = new UserPreference("dog", Arrays.asList("golden"), 0, 1, "happy", "toronto", "male");
        AdopterUser user = new AdopterUser("jenny", "dog", "jenny", "test email", "613",
                null, userPreference);
        Pet pet = new Pet("person", "email", "111", 1, "dog", 1, "golden",
                null, "male", "happy", "is a dog", "toronto", true);
        ArrayList<Pet> listp = new ArrayList<>(Arrays.asList(pet));

        when(mockPetDAO.getPreferencePets(userPreference)).thenReturn(listp);
        when(mockUserDAO.get("jenny")).thenReturn(user);

        interactor.execute(input);

        ArgumentCaptor<DisplayAllPetsOutputData> captor = ArgumentCaptor.forClass(DisplayAllPetsOutputData.class);
        verify(mockPresenter).displayAllPetsOutput(captor.capture());

        DisplayAllPetsOutputData output = captor.getValue();
        assertEquals(pet, output.getPets().get(0));
    }
}
