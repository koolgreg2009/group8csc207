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

class FileApiInfoDAOIntegrationTest {

    private FileApiInfoDAO fileApiInfoDAO;
    private File tempFile;

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

    @AfterEach
    void tearDown() {
        // Clean up the temp file after each test
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void testInitializationWithEmptyFile() throws IOException {
        // Verify that getBreedInfo() and getLocation() are called during initialization
        verify(fileApiInfoDAO, times(1)).getBreedInfo();
        verify(fileApiInfoDAO, times(1)).getLocation();
    }

    @Test
    void testGetBreedInfo() throws IOException {
        List<String> breeds = fileApiInfoDAO.getData("breeds");
        assertEquals(77, breeds.size());  // Adjust the expected value based on real API response
    }

    @Test
    void testGetLocation() throws IOException {
        List<String> locations = fileApiInfoDAO.getData("locations");
        assertEquals(61, locations.size());  // Adjust the expected value based on real API response
    }

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

    @Test
    void testSave() {
        List<String> breedNames = List.of("Abyssinian", "American Curl");
        fileApiInfoDAO.save("breeds", breedNames);

        List<String> savedBreeds = fileApiInfoDAO.getData("breeds");
        assertEquals(2, savedBreeds.size());
        assertEquals("Abyssinian", savedBreeds.get(0));
        assertEquals("American Curl", savedBreeds.get(1));
    }

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
