package use_case.get_matching_strings;

import data_access.APIInfoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import use_case.get_matching_strings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetMatchStringInteractorTest {

    private APIInfoInterface infoDAO;
    private GetMatchingStringOutputBoundary infoPresenter;
    private GetMatchStringInteractor interactor;

    @BeforeEach
    public void setUp() {
        infoDAO = mock(APIInfoInterface.class);
        infoPresenter = mock(GetMatchingStringOutputBoundary.class);
        interactor = new GetMatchStringInteractor(infoDAO, infoPresenter);
    }

    @Test
    public void testExecuteWithKeyLocations() {
        // Arrange
        String key = "locations";
        String input = "S";
        GetMatchingStringInputData inputData = new GetMatchingStringInputData(key, input);

        List<String> locations = Arrays.asList("Sistersville, WV", "Philadelphia, PA", "Buford, GA", "Frankston, TX", "SF, NM", "Westminster, MD");
        when(infoDAO.getData(key)).thenReturn(locations);

        // Act
        interactor.execute(inputData);

        // Assert
        ArgumentCaptor<GetMatchingStringOutputData> captor = ArgumentCaptor.forClass(GetMatchingStringOutputData.class);
        verify(infoPresenter).prepareSuccessView(captor.capture());

        List<String> expectedFiltered = Arrays.asList("Sistersville, WV", "SF, NM");
        assertEquals(expectedFiltered, captor.getValue().getMatchingStrings());
    }

    @Test
    public void testExecuteWithKeyBreeds() {
        // Arrange
        String key = "breeds";
        String input = "A";
        GetMatchingStringInputData inputData = new GetMatchingStringInputData(key, input);

        List<String> breeds = Arrays.asList("Abyssinian", "American Curl", "American Shorthair", "American Wirehair", "Angora", "Applehead Siamese",
                "Balinese", "Bengal", "Birman", "Bobtail", "Bombay", "British Shorthair", "Burmese", "Burmilla", "Calico", "Canadian Hairless",
                "Chausie", "Chinchilla", "Cornish Rex", "Cymric", "Devon Rex", "Dilute Tortoiseshell", "Domestic Long Hair", "Domestic Medium Hair",
                "Domestic Short Hair", "Egyptian Mau", "Exotic Shorthair", "Havana", "Himalayan", "Japanese Bobtail", "Korat", "Maine Coon", "Manx",
                "Norwegian Forest Cat", "Ocicat");
        when(infoDAO.getData(key)).thenReturn(breeds);

        // Act
        interactor.execute(inputData);

        // Assert
        ArgumentCaptor<GetMatchingStringOutputData> captor = ArgumentCaptor.forClass(GetMatchingStringOutputData.class);
        verify(infoPresenter).prepareSuccessView(captor.capture());

        List<String> expectedFiltered = Arrays.asList("Abyssinian", "American Curl", "American Shorthair", "American Wirehair", "Angora", "Applehead Siamese");
        assertEquals(expectedFiltered, captor.getValue().getMatchingStrings());
    }

    @Test
    public void testExecuteWithNoMatches() {
        // Arrange
        String key = "breeds";
        String input = "Z";
        GetMatchingStringInputData inputData = new GetMatchingStringInputData(key, input);

        List<String> breeds = Arrays.asList("Abyssinian", "American Curl", "American Shorthair", "American Wirehair", "Angora", "Applehead Siamese");
        when(infoDAO.getData(key)).thenReturn(breeds);

        // Act
        interactor.execute(inputData);

        // Assert
        ArgumentCaptor<GetMatchingStringOutputData> captor = ArgumentCaptor.forClass(GetMatchingStringOutputData.class);
        verify(infoPresenter).prepareSuccessView(captor.capture());

        List<String> expectedFiltered = new ArrayList<>(); // No matches expected
        assertEquals(expectedFiltered, captor.getValue().getMatchingStrings());
    }
}
