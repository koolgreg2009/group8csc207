package use_case.display_bookmark_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.BookmarkDTO;
import dto.PetDTO;
import entity.Bookmark;
import entity.Pet;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import use_case.display_bookmark_pets.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DisplayBookmarkInteractorTest {
    private PetDAOInterface petDAO;
    private UserDAOInterface userDAO;
    private DisplayBookmarkPetsOutputBoundary presenter;
    private DisplayBookmarkInteractor interactor;

    @BeforeEach
    void setUp() {
        petDAO = Mockito.mock(PetDAOInterface.class);
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(DisplayBookmarkPetsOutputBoundary.class);
        interactor = new DisplayBookmarkInteractor(userDAO, petDAO, presenter);
    }

    @Test
    void testExecuteNoBookmarks() {
        AdopterUser user = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        when(userDAO.get("user1")).thenReturn(user);

        DisplayBookmarkInputData inputData = new DisplayBookmarkInputData("user1");
        interactor.execute(inputData);

        ArgumentCaptor<DisplayBookmarkPetsOutputData> argumentCaptor = ArgumentCaptor.forClass(DisplayBookmarkPetsOutputData.class);
        verify(presenter).displayPetsOutput(argumentCaptor.capture());

        DisplayBookmarkPetsOutputData outputData = argumentCaptor.getValue();
        assertEquals(0, outputData.getBookmarks().size());
    }

    @Test
    void testExecuteWithBookmarks() {
        AdopterUser user = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        Bookmark bookmark1 = new Bookmark(1, LocalDateTime.now());
        Bookmark bookmark2 = new Bookmark(2, LocalDateTime.now());
        user.addBookmark(bookmark1);
        user.addBookmark(bookmark2);

        Pet pet1 = new Pet("Owner1", "owner1@example.com", "1234567890", 1, "Cat", 2, "Breed1", "Male", "High", "Description1", "Location1", true, "Fluffy", "");
        Pet pet2 = new Pet("Owner2", "owner2@example.com", "0987654321", 2, "Dog", 3, "Breed2", "Female", "Medium", "Description2", "Location2", true, "Buddy", "");

        when(userDAO.get("user1")).thenReturn(user);
        when(petDAO.get(1)).thenReturn(pet1);
        when(petDAO.get(2)).thenReturn(pet2);

        DisplayBookmarkInputData inputData = new DisplayBookmarkInputData("user1");
        interactor.execute(inputData);

        ArgumentCaptor<DisplayBookmarkPetsOutputData> argumentCaptor = ArgumentCaptor.forClass(DisplayBookmarkPetsOutputData.class);
        verify(presenter).displayPetsOutput(argumentCaptor.capture());

        DisplayBookmarkPetsOutputData outputData = argumentCaptor.getValue();
        assertEquals(2, outputData.getBookmarks().size());

        BookmarkDTO bookmarkDTO1 = outputData.getBookmarks().get(0);
        BookmarkDTO bookmarkDTO2 = outputData.getBookmarks().get(1);

        assertEquals(pet1.getPetID(), bookmarkDTO1.getPet().getPetID());
        assertEquals(pet2.getPetID(), bookmarkDTO2.getPet().getPetID());
    }
}
