package data_access;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Unit test class for testing the FileApiInfoDAO class.
 */
class FileApiInfoDAOTest {

    @Mock
    private File mockJsonFile;

    private FileApiInfoDAO fileApiInfoDAO;
    private File realFile;

    private final String breedApiResponse = "{\n" +
            "  \"meta\": {\n" +
            "    \"count\": 77,\n" +
            "    \"countReturned\": 2,\n" +
            "    \"pageReturned\": 1,\n" +
            "    \"pages\": 39,\n" +
            "    \"limit\": 2,\n" +
            "    \"transactionId\": \"qMPhtEJfIloP\"\n" +
            "  },\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"type\": \"breeds\",\n" +
            "      \"id\": \"1\",\n" +
            "      \"attributes\": {\n" +
            "        \"name\": \"Abyssinian\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"breeds\",\n" +
            "      \"id\": \"2\",\n" +
            "      \"attributes\": {\n" +
            "        \"name\": \"American Curl\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private final String locationApiResponse = "{\n" +
            "  \"meta\": {\n" +
            "    \"count\": 34021,\n" +
            "    \"countReturned\": 1,\n" +
            "    \"pageReturned\": 1,\n" +
            "    \"limit\": 1,\n" +
            "    \"pages\": 34021,\n" +
            "    \"transactionId\": \"CTlBIHFKzABP\"\n" +
            "  },\n" +
            "  \"included\": [\n" +
            "    {\n" +
            "      \"type\": \"locations\",\n" +
            "      \"id\": \"1000006685\",\n" +
            "      \"attributes\": {\n" +
            "        \"citystate\": \"Kanab, UT\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    /**
     * Sets up the test environment before each test.
     * Initializes mocks, creates the real file, and prepares the FileApiInfoDAO instance.
     *
     * @throws IOException if an I/O error occurs during setup.
     */
    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        // Initialize the real file that will be used
        realFile = new File("mockPath");

        doReturn(false).when(mockJsonFile).exists();
        doReturn(0L).when(mockJsonFile).length();

        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        doThrow(new IOException("Simulated IOException")).when(mockObjectMapper).writeValue(any(File.class), any(Map.class));
        fileApiInfoDAO = spy(new FileApiInfoDAO("mockPath") {
            @Override
            protected String makeAPICall(String endpoint) throws IOException {
                if (endpoint.equals("/public/animals/breeds/search/cats?limit=250")) {
                    return breedApiResponse;
                } else if (endpoint.equals("/public/animals/search/available/cats?limit=250")) {
                    return locationApiResponse;
                }
                return "";
            }
        });
    }

    /**
     * Cleans up the test environment after each test.
     * Deletes the real file that was used during the test.
     */
    @AfterEach
    void tearDown() {
        // Clean up the real file after each test
        if (realFile.exists()) {
            realFile.delete();
        }
    }

    /**
     * Tests the getBreedInfo method of FileApiInfoDAO.
     * Verifies that the method correctly retrieves and stores breed information.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    void testGetBreedInfo() throws IOException {
        fileApiInfoDAO.getBreedInfo();

        List<String> breeds = fileApiInfoDAO.getData("breeds");
        assertEquals(2, breeds.size());
        assertEquals("Abyssinian", breeds.get(0));
        assertEquals("American Curl", breeds.get(1));
    }

    /**
     * Tests the getLocation method of FileApiInfoDAO.
     * Verifies that the method correctly retrieves and stores location information.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    void testGetLocation() throws IOException {
        fileApiInfoDAO.getLocation();

        List<String> locations = fileApiInfoDAO.getData("locations");
        assertEquals(1, locations.size());
        assertEquals("Kanab, UT", locations.get(0));
    }

    /**
     * Tests the exists method of FileApiInfoDAO.
     * Verifies that the method correctly checks the existence of breed and location data.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    void testExists() throws IOException {
        fileApiInfoDAO.getBreedInfo();
        fileApiInfoDAO.getLocation();

        boolean existsBreed = fileApiInfoDAO.exists("Abyssinian", "breeds");
        assertTrue(existsBreed);

        boolean existsLocation = fileApiInfoDAO.exists("Kanab, UT", "locations");
        assertTrue(existsLocation);

        boolean doesNotExist = fileApiInfoDAO.exists("Tabby", "breeds");
        assertFalse(doesNotExist);

        boolean doesNotExistNull = fileApiInfoDAO.exists("Sistersville, WV", "locations");
        assertFalse(doesNotExistNull);

        List<String> breedsExist = asList("Abyssinian", "American Curl");
        List<String> breedsNotExist = List.of("Tabby");

        boolean existList = fileApiInfoDAO.exists(breedsExist, "breeds");
        assertTrue(existList);

        boolean notExistList = fileApiInfoDAO.exists(breedsNotExist, "breeds");
        assertFalse(notExistList);
    }

    /**
     * Tests the save method of FileApiInfoDAO.
     * Verifies that the method correctly saves breed data.
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
     * Tests the save method of FileApiInfoDAO for exception handling.
     * Verifies that the method throws a RuntimeException when an IOException occurs during saving.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    void testSaveException() throws IOException {
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);

        doThrow(new IOException("Simulated IOException")).when(mockObjectMapper).writeValue(any(File.class), any(Map.class));

        fileApiInfoDAO = spy(new FileApiInfoDAO("mockPath") {
            @Override
            protected ObjectMapper getObjectMapper() {
                return mockObjectMapper;
            }
        });

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            fileApiInfoDAO.save("rdmKEY", List.of(""));
        });

        assertEquals("Simulated IOException", thrown.getCause().getMessage());
    }
}
