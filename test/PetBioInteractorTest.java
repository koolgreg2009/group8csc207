package test;

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
import use_case.pet_bio.PetBioInputData;
import use_case.pet_bio.PetBioInteractor;
import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;

/** Unit test for PetBioInteractor
 */
@ExtendWith(MockitoExtension.class)
public class PetBioInteractorTest {

	//mocking output boundary
	@Mock
	private PetBioOutputBoundary mockPresenter;

	@Mock
	private PetDAOInterface mockDao;

	private PetBioInteractor target;

	@BeforeEach
	public void setup() {
		target = new PetBioInteractor(mockPresenter, mockDao);
	}

	@Test
	public void testExecute() {
		PetBioInputData input = new PetBioInputData(1);
		Pet pet = new Pet("test", "test email", "1111", 1, "Dog", 10, "", null, null, null, null, null, false);
		when(mockDao.get(1)).thenReturn(pet);

		target.execute(input);

		ArgumentCaptor<PetBioOutputData> outputCaptor = ArgumentCaptor.forClass(PetBioOutputData.class);
		verify(mockPresenter).preparePetBio(outputCaptor.capture());

		// Verify the name property of the captured argument
		PetBioOutputData output = outputCaptor.getValue();
		assertEquals("test", output.getPet().getOwner());
	}
}
