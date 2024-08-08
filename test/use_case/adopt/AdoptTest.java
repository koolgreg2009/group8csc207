package use_case.adopt;


import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdoptTest {
    private PetDAOInterface petDAO;
    private UserDAOInterface userDAO;
    private AdoptOutputBoundary userPresenter;
    private AdoptInputBoundary adoptInteractor;

    @BeforeEach
    void setUp() {
        petDAO = Mockito.mock(PetDAOInterface.class);
        userDAO = Mockito.mock(UserDAOInterface.class);
        userPresenter = Mockito.mock(AdoptOutputBoundary.class);
        adoptInteractor = new Adopt(petDAO, userPresenter, userDAO);
    }

    @Test
    void testExecutePetAlreadyAdopted() {
        Pet pet = new Pet("Owner", "owner@example.com", "1234567890", 1, "Cat", 2, "Breed", "Male", "High", "Description", "Location", false, "Fluffy", "");

        when(petDAO.get(1)).thenReturn(pet);

        AdoptInputData inputData = new AdoptInputData(1);
        adoptInteractor.execute(inputData);

        verify(petDAO, times(1)).get(1);
        verify(userDAO, never()).removePetFromAllUserBookmarks(anyInt());
        verify(petDAO, never()).save(any(Pet.class));
        verify(userPresenter, never()).prepareAdopt(any(AdoptOutputData.class));
    }

    @Test
    void testExecutePetAvailableForAdoption() {
        Pet pet = new Pet("Owner", "owner@example.com", "1234567890", 1, "Cat", 2, "Breed", "Male", "High", "Description", "Location", true, "Fluffy", "");
        List<String> users = Arrays.asList("user1", "user2");

        when(petDAO.get(1)).thenReturn(pet);
        when(userDAO.removePetFromAllUserBookmarks(1)).thenReturn(users);
        AdopterUser user1 = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        AdopterUser user2 = new AdopterUser("user2", "password", "User Two", "email2@example.com", "456");
        when(userDAO.get("user1")).thenReturn(user1);
        when(userDAO.get("user2")).thenReturn(user2);

        AdoptInputData inputData = new AdoptInputData(1);
        adoptInteractor.execute(inputData);

        verify(petDAO, times(1)).get(1);
        verify(userDAO, times(1)).removePetFromAllUserBookmarks(1);
        verify(petDAO, times(1)).save(pet);
        verify(userPresenter, times(1)).prepareAdopt(any(AdoptOutputData.class));

        assertEquals(false, pet.isAvailable());
        assertEquals(1, user1.getNotifications().size());
        assertEquals("Fluffy has found a home.", user1.getNotifications().get(0));
        assertEquals(1, user2.getNotifications().size());
        assertEquals("Fluffy has found a home.", user2.getNotifications().get(0));
    }
}