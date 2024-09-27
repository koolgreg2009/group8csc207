package use_case.pet_bio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import data_access.PetDAOInterface;
import entity.Pet;

/**
 * Unit test for the {@link PetBioInteractor} class.
 * This class tests the functionality of the {@link PetBioInteractor}'s execute method
 * which is responsible for fetching and preparing pet biography data.
 */
@ExtendWith(MockitoExtension.class)
public class PetBioInteractorTest {

	@Mock
	private PetBioOutputBoundary mockPresenter;

	@Mock
	private PetDAOInterface mockDao;

	private PetBioInteractor target;

	/**
	 * Sets up the test environment, initializing the {@link PetBioInteractor} instance
	 * with mocked dependencies before each test.
	 */
	@BeforeEach
	public void setup() {
		target = new PetBioInteractor(mockPresenter, mockDao);
	}

	/**
	 * Tests the {@link PetBioInteractor#execute(PetBioInputData)} method for a successful execution.
	 * Verifies that the {@link PetBioOutputBoundary#preparePetBio(PetBioOutputData)} method
	 * is called with the expected {@link PetBioOutputData} object.
	 *
	 * The test ensures that the pet information is correctly retrieved from the mock DAO
	 * and passed to the presenter with accurate data.
	 */
	@Test
	public void testExecute() {
		PetBioInputData input = new PetBioInputData("testuser", 1);
		Pet pet = new Pet("test", "john@example.com", "1234567890", 1, "Dog", 3, "Bulldog",
				"Male", "High", "Loves to play", "New York", true, "John", "");
		when(mockDao.get(1)).thenReturn(pet);

		target.execute(input);

		ArgumentCaptor<PetBioOutputData> outputCaptor = ArgumentCaptor.forClass(PetBioOutputData.class);
		verify(mockPresenter).preparePetBio(outputCaptor.capture());

		PetBioOutputData output = outputCaptor.getValue();
		assertEquals("test", output.getPet().getOwner());
	}
}
