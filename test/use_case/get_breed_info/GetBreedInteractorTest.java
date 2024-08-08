package use_case.get_breed_info;

import data_access.CatDAOInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GetBreedInteractorTest {
    private CatDAOInterface catDAO;
    private GetBreedOutputBoundary presenter;
    private GetBreedInteractor interactor;

    @BeforeEach
    void setUp() {
        catDAO = Mockito.mock(CatDAOInterface.class);
        presenter = Mockito.mock(GetBreedOutputBoundary.class);
        interactor = new GetBreedInteractor(catDAO, presenter);
    }

    @Test
    void testExecuteBreedFound() {
        HashMap<String, Object> breedInfo = new HashMap<>();
        breedInfo.put("name", "Persian");
        breedInfo.put("description", "The Persian cat is a long-haired breed of cat.");
        breedInfo.put("adaptability", 5);
        breedInfo.put("affection_level", 5);
        breedInfo.put("child_friendly", 4);
        breedInfo.put("dog_friendly", 3);
        breedInfo.put("energy_level", 2);
        breedInfo.put("image_url", "https://example.com/persian.jpg");

        when(catDAO.getBreedInformation("Persian")).thenReturn(breedInfo);

        GetBreedInputData inputData = new GetBreedInputData("Persian");
        interactor.execute(inputData);

        ArgumentCaptor<GetBreedOutputData> argumentCaptor = ArgumentCaptor.forClass(GetBreedOutputData.class);
        verify(presenter).prepareGetBreedView(argumentCaptor.capture());

        GetBreedOutputData outputData = argumentCaptor.getValue();

        assertEquals("Persian", outputData.getBreedName());
        assertEquals("The Persian cat is a long-haired breed of cat.", outputData.getDescription());
        assertEquals("5", outputData.getAdaptability());
        assertEquals("5", outputData.getAffectionLevel());
        assertEquals("4", outputData.getChildFriendly());
        assertEquals("3", outputData.getDogFriendly());
        assertEquals("2", outputData.getEnergyLevel());
        assertEquals("https://example.com/persian.jpg", outputData.getImgUrl());
    }

    @Test
    void testExecuteBreedNotFound() {
        when(catDAO.getBreedInformation("UnknownBreed")).thenReturn(null);

        GetBreedInputData inputData = new GetBreedInputData("UnknownBreed");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();

        assertEquals("Information on UnknownBreed could not be found.", errorMessage);
    }
}
