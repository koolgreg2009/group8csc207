//package use_case.adopt;
//
//import data_access.FilePetDAO;
//import data_access.FileUserDAO;
//import entity.user.AdopterUser;
//import interface_adapter.adopt.AdoptPresenter;
//import interface_adapter.bookmark.AddBookmarkPresenter;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import use_case.bookmarks.AddBookmarkInteractor;
//import use_case.bookmarks.BookmarkInputData;
//
//import java.io.File;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AdoptTest{
//    private FileUserDAO userDAO;
//    private FilePetDAO petDAO;
//    private AdoptPresenter adoptPresenter;
//    private Adopt adoptInteractor;
//    private String testFilePath = "testUserData.json";
//
//    @BeforeEach
//    void setUp() throws IOException {
//        // Create a new FileUserDAO and FilePetDAO with a temporary file path
//        userDAO = new FileUserDAO(testFilePath);
//        petDAO = new FilePetDAO(testFilePath);
//        adoptPresenter = new AdoptPresenter();
//        adoptInteractor = new Adopt(petDAO, adoptPresenter, userDAO);
//
//        AdopterUser user = new AdopterUser("testUser", "password", "Test Name", "test@example.com", "1234567890");
//        userDAO.save(user);
//    }
//
//    @Test
//    void testAdopt() {
//        AdoptInputData adpData = new AdoptInputData(123);  // Assuming petID is an int
//
//        adoptInteractor.execute(adpData);
//    }
//
//    @AfterEach
//    void tearDown() {
//        new File(testFilePath).delete();
//    }
//}