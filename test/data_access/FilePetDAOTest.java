package data_access;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Pet;
import entity.preference.UserPreference;

/**
 * Unit tests for the {@link FilePetDAO} class.
 * This class verifies the correct behavior of the FilePetDAO methods for saving and retrieving pet information.
 */
class FilePetDAOTest {
    private static final String TEST_JSON_PATH = "test_pets.json";
    private FilePetDAO petDAO;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the {@link FilePetDAO} instance with a path to a test JSON file.
     *
     * @throws IOException if an I/O error occurs while initializing the test file
     */
    @BeforeEach
    void setUp() throws IOException {
        petDAO = new FilePetDAO(TEST_JSON_PATH);
    }

    /**
     * Cleans up the test environment after each test method is executed.
     * Deletes the test JSON file if it exists.
     */
    @AfterEach
    void tearDown() {
        File testFile = new File(TEST_JSON_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    /**
     * Tests the {@link FilePetDAO#save(Pet)} and {@link FilePetDAO#get(int)} methods.
     * Verifies that a pet can be saved and subsequently retrieved with correct details.
     */
    @Test
    void testSaveAndGetPet() {
		Pet pet = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog",
				"Male", "High", "Loves to play", "New York", true, "test", "");
        petDAO.save(pet);

        Pet retrievedPet = petDAO.get(1);
        assertNotNull(retrievedPet);
        assertEquals("Dog", retrievedPet.getSpecies());
        assertEquals("Bulldog", retrievedPet.getBreed());
    }

    /**
     * Tests the {@link FilePetDAO#getPreferencePets(UserPreference)} method.
     * Verifies that pets matching the user preference criteria are correctly retrieved.
     */
    @Test
    void testGetPreferencePets() {
		Pet pet1 = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog",
				"Male", "High", "Loves to play", "New York", true, "John", "");
		Pet pet2 = new Pet("Jane Doe", "jane@example.com", "0987654321", 2, "Cat", 2, "Siamese",
				"Female", "Medium", "Loves to nap", "Los Angeles", true, "Jane", "");
        petDAO.save(pet1);
        petDAO.save(pet2);

        UserPreference userPreference = new UserPreference("Dog", null, 0, 5, null, null, null);

        ArrayList<Pet> matchingPets = petDAO.getPreferencePets(userPreference);
        assertEquals(1, matchingPets.size());
        assertEquals("Dog", matchingPets.get(0).getSpecies());
    }

    /**
     * Tests the {@link FilePetDAO#getPreferencePets(UserPreference)} method with multiple criteria.
     * Verifies that pets matching all specified criteria are correctly retrieved.
     */
    @Test
    void testGetPreferencePetsByMultipleCriteria() {
		Pet pet1 = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog",
				"Male", "High", "Loves to play", "New York", true, "John", "");
		Pet pet2 = new Pet("Jane Doe", "jane@example.com", "0987654321", 2, "Dog", 2, "Poodle",
				"Female", "Medium", "Loves to nap", "New York", true, "Jane", "");
        petDAO.save(pet1);
        petDAO.save(pet2);

        UserPreference userPreference = new UserPreference("Dog", null, 0, 5, null, "New York", "Female");

        ArrayList<Pet> matchingPets = petDAO.getPreferencePets(userPreference);
        assertEquals(1, matchingPets.size());
        assertEquals("Poodle", matchingPets.get(0).getBreed());
    }
}
