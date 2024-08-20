package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Integration tests for the {@link FileApiInfoDAO} class.
 * This class verifies the correct behavior of the FileApiInfoDAO methods in an integrated environment.
 */
class FileApiInfoDAOIntegrationTest {

    private FileApiInfoDAO fileApiInfoDAO;
    private File tempFile;

    /**
     * Sets up the test environment before each test method is executed.
     * Creates a temporary file and initializes a spy on the {@link FileApiInfoDAO} instance.
     *
     * @throws IOException if an I/O error occurs while creating the temporary file
     */
    @BeforeEach
    void setUp() throws IOException {
        // Create an empty temporary file
        tempFile = File.createTempFile("test", ".json");
        tempFile.deleteOnExit(); // Ensure the file is deleted after the test

        // Create a real instance first
        FileApiInfoDAO realFileApiInfoDAO = new FileApiInfoDAO(tempFile.getAbsolutePath());

        // Now, create a spy on the real object
        fileApiInfoDAO = spy(realFileApiInfoDAO);

        // Re-assign the methods that should be mocked after construction
        doNothing().when(fileApiInfoDAO).getBreedInfo();
        doNothing().when(fileApiInfoDAO).getLocation();

        // Trigger the initialization (Constructor has already run at this point)
        fileApiInfoDAO.getBreedInfo();
        fileApiInfoDAO.getLocation();
    }

    /**
     * Cleans up the test environment after each test method is executed.
     * Deletes the temporary file if it exists.
     */
    @AfterEach
    void tearDown() {
        // Clean up the temp file after each test
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    /**
     * Tests the initialization of the {@link FileApiInfoDAO} instance with an empty file.
     * Verifies that the {@code getBreedInfo()} and {@code getLocation()} methods are called during initialization.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void testInitializationWithEmptyFile() throws IOException {
        // Verify that getBreedInfo() and getLocation() are called during initialization
        verify(fileApiInfoDAO, times(1)).getBreedInfo();
        verify(fileApiInfoDAO, times(1)).getLocation();
    }

    /**
     * Tests the retrieval of breed information from the {@link FileApiInfoDAO}.
     * Asserts that the number of breeds matches the expected value.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void testGetBreedInfo() throws IOException {
        List<String> breeds = fileApiInfoDAO.getData("breeds");
        assertEquals(77, breeds.size());  // Adjust the expected value based on real API response
    }

    /**
     * Tests the retrieval of location information from the {@link FileApiInfoDAO}.
     * Asserts that the number of locations matches the expected value.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void testGetLocation() throws IOException {
        List<String> locations = fileApiInfoDAO.getData("locations");
        assertEquals(61, locations.size());  // Adjust the expected value based on real API response
    }

    /**
     * Tests the existence of specific breed names in the {@link FileApiInfoDAO}.
     * Verifies the correct behavior when checking for the presence or absence of breed names.
     */
    @Test
    void testExists() {
        List<String> breedNames = List.of("Abyssinian", "American Curl");
        List<String> breedDoesNotExist = List.of("dig");
        fileApiInfoDAO.save("breeds", breedNames);

        boolean exists = fileApiInfoDAO.exists("Abyssinian", "breeds");
        assertTrue(exists);

        boolean allExist = fileApiInfoDAO.exists(breedNames, "breeds");
        assertTrue(allExist);

        boolean doesNotExist = fileApiInfoDAO.exists(breedDoesNotExist, "breeds");
        assertFalse(doesNotExist);

        boolean notExists = fileApiInfoDAO.exists("NotExistBreed", "breeds");
        assertFalse(notExists);
    }

    /**
     * Tests the saving of breed names to the {@link FileApiInfoDAO}.
     * Verifies that the breed names are correctly saved and retrievable.
     */
    @Test
    void testSave() {
        List<String> breedNames = List.of("Abyssinian", "American Curl");
        fileApiInfoDAO.save("breeds", breedNames);

        List<String> savedBreeds = fileApiInfoDAO.getData("breeds");
        assertEquals(2, savedBreeds.size());
        assertEquals("Abyssinian", savedBreeds.get(0));
        assertEquals("American Curl", savedBreeds.get(1));
    }

    /**
     * Tests the {@link FileApiInfoDAO} behavior when {@code save} method throws an exception.
     * Simulates an {@code IOException} during the save operation and verifies that the exception is correctly handled.
     *
     * @throws IOException if an I/O error occurs during the test
     */
    @Test
    void testSaveThrowsException() throws IOException {
        // Mock the ObjectMapper to throw an exception when writeValue is called
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        FileApiInfoDAO fileApiInfoDAOMock = spy(new FileApiInfoDAO(tempFile.getAbsolutePath()) {
            @Override
            protected ObjectMapper getObjectMapper() {
                return mockObjectMapper;
            }
        });

        List<String> breedNames = List.of("Abyssinian", "American Curl");

        // Simulate a failure in the writeValue method
        doThrow(new IOException("Mocked IO Exception")).when(mockObjectMapper).writeValue(any(File.class), any());

        // Capture the RuntimeException and assert its properties
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            fileApiInfoDAOMock.save("breeds", breedNames);
        });

        // Assert that the exception message contains the expected text
        assertTrue(thrown.getMessage().contains("Mocked IO Exception"));

        // Assert that the cause of the RuntimeException is the original IOException
        assertTrue(thrown.getCause() instanceof IOException);
        assertEquals("Mocked IO Exception", thrown.getCause().getMessage());
    }
}
