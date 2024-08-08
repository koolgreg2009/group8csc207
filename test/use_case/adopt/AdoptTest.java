package use_case.adopt;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.user.AdopterUser;
import entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdoptTest {
    private PetDAOInterface petDAO;
    private UserDAOInterface userDAO;
    private AdoptOutputBoundary presenter;
    private Adopt interactor;

    @BeforeEach
    void setUp() {
        petDAO = Mockito.mock(PetDAOInterface.class);
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(AdoptOutputBoundary.class);
        interactor = new Adopt(petDAO, presenter, userDAO);
    }

    @Test
    void testExecutePetAlreadyAdopted() {
        Pet pet = Mockito.mock(Pet.class);
        when(petDAO.get(1)).thenReturn(pet);
        when(pet.isAvailable()).thenReturn(false);

        AdoptInputData inputData = new AdoptInputData(1);
        interactor.execute(inputData);

        verify(presenter, never()).prepareAdopt(any());
    }

    @Test
    void testExecuteSuccessfulAdoption() {
        Pet pet = Mockito.mock(Pet.class);
        when(petDAO.get(1)).thenReturn(pet);
        when(pet.isAvailable()).thenReturn(true);
        when(pet.getPetID()).thenReturn(1);
        when(pet.getName()).thenReturn("Fluffy");
        when(pet.getOwner()).thenReturn("John Doe");
        when(pet.getEmail()).thenReturn("johndoe@example.com");
        when(pet.getPhoneNum()).thenReturn("123456789");

        AdopterUser user1 = Mockito.mock(AdopterUser.class);
        AdopterUser user2 = Mockito.mock(AdopterUser.class);

        when(userDAO.get("user1")).thenReturn(user1);
        when(userDAO.get("user2")).thenReturn(user2);

        List<String> users = Arrays.asList("user1", "user2");
        when(userDAO.removePetFromAllUserBookmarks(1)).thenReturn(users);

        AdoptInputData inputData = new AdoptInputData(1);
        interactor.execute(inputData);

        verify(pet).markUnavailable();
        verify(petDAO).save(pet);

        verify(user1).addNotif("Fluffy has found a home.");
        verify(user2).addNotif("Fluffy has found a home.");

        ArgumentCaptor<AdoptOutputData> argumentCaptor = ArgumentCaptor.forClass(AdoptOutputData.class);
        verify(presenter).prepareAdopt(argumentCaptor.capture());

        AdoptOutputData outputData = argumentCaptor.getValue();
        assertEquals("John Doe", outputData.getPetOwner());
        assertEquals("johndoe@example.com", outputData.getOwnerEmail());
        assertEquals("123456789", outputData.getOwnerPhone());
        assertEquals("Fluffy", outputData.getID());
    }
}
