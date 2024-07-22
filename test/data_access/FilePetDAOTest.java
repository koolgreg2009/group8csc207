package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entity.Pet;
import entity.preference.UserPreference;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePetDAOTest {
    private static final String TEST_JSON_PATH = "test_pets.json";
    private FilePetDAO petDAO;

    @BeforeEach
    void setUp() throws IOException {
        petDAO = new FilePetDAO(TEST_JSON_PATH);
    }

    @AfterEach
    void tearDown() {
        File testFile = new File(TEST_JSON_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testSaveAndGetPet() {
        Pet pet = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog", List.of("Friendly", "Active"), "Male", "High", "Loves to play", "New York", true);
        petDAO.save(pet);

        Pet retrievedPet = petDAO.get(1);
        assertNotNull(retrievedPet);
        assertEquals("Dog", retrievedPet.getSpecies());
        assertEquals("Bulldog", retrievedPet.getBreed());
    }

    @Test
    void testGetPreferencePets() {
        Pet pet1 = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog", List.of("Friendly", "Active"), "Male", "High", "Loves to play", "New York", true);
        Pet pet2 = new Pet("Jane Doe", "jane@example.com", "0987654321", 2, "Cat", 2, "Siamese", List.of("Calm", "Quiet"), "Female", "Medium", "Loves to nap", "Los Angeles", true);
        petDAO.save(pet1);
        petDAO.save(pet2);

        UserPreference userPreference = new UserPreference();
        userPreference.setSpecies("Dog");

        ArrayList<Pet> matchingPets = petDAO.getPreferencePets(userPreference);
        assertEquals(1, matchingPets.size());
        assertEquals("Dog", matchingPets.get(0).getSpecies());
    }

    @Test
    void testGetPreferencePetsByMultipleCriteria() {
        Pet pet1 = new Pet("John Doe", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog", List.of("Friendly", "Active"), "Male", "High", "Loves to play", "New York", true);
        Pet pet2 = new Pet("Jane Doe", "jane@example.com", "0987654321", 2, "Dog", 2, "Poodle", List.of("Friendly", "Quiet"), "Female", "Medium", "Loves to nap", "New York", true);
        petDAO.save(pet1);
        petDAO.save(pet2);

        UserPreference userPreference = new UserPreference();
        userPreference.setSpecies("Dog");
        userPreference.setLocation("New York");
        userPreference.setGender("Female");

        ArrayList<Pet> matchingPets = petDAO.getPreferencePets(userPreference);
        assertEquals(1, matchingPets.size());
        assertEquals("Poodle", matchingPets.get(0).getBreed());
    }
}
