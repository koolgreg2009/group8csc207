//package use_case.bookmarks;
//
//import data_access.FileUserDAO;
//import entity.user.AdopterUser;
//import interface_adapter.bookmark.AddBookmarkPresenter;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.io.File;
//import java.io.IOException;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// * Unit test class for AddBookmarkInteractor.
// * This class tests the functionality of the AddBookmarkInteractor using JUnit 5.
// */
//class AddBookmarkInteractorTest {
//
//    private FileUserDAO fileUserDAO;
//    private AddBookmarkPresenter presenter;
//    private AddBookmarkInteractor interactor;
//    private String testFilePath = "testUserData.json";
//
//    /**
//     * Sets up the necessary objects before each test is run.
//     *
//     * @throws IOException if an I/O error occurs during setup.
//     */
//    @BeforeEach
//    void setUp() throws IOException {
//        // Create a new FileUserDAO with a temporary file path
//        fileUserDAO = new FileUserDAO(testFilePath);
//        presenter = new AddBookmarkPresenter();
//        interactor = new AddBookmarkInteractor(presenter, fileUserDAO);
//
//        AdopterUser user = new AdopterUser("testUser", "password", "Test Name", "test@example.com", "1234567890");
//        fileUserDAO.save(user);
//    }
//
//    /**
//     * Tests the success scenario of adding a bookmark.
//     * Verifies that the bookmark is correctly added to the user's list of bookmarks.
//     */
//    @Test
//    void testAddBookmarkSuccess() {
//        BookmarkInputData inputData = new BookmarkInputData("testUser", 1);  // Assuming petID is an int
//
//        interactor.execute(inputData);
//
//        AdopterUser user = (AdopterUser) fileUserDAO.get("testUser");
//        assertTrue(user.getBookmarks().stream().anyMatch(b -> b.getPetID() == 1));
//    }
//
//    /**
//     * Cleans up the test environment after each test is run.
//     * Deletes the temporary file used for testing.
//     */
//    @AfterEach
//    void tearDown() {
//        new File(testFilePath).delete();
//    }
//}
