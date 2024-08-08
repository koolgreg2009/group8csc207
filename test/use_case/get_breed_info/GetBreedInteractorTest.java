//package use_case.get_breed_info;
//
//import data_access.CatDAOInterface;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class GetBreedInteractorIntegrationTest {
//
//    private CatDAOInterface catDAO;
//    private GetBreedOutputBoundary getBreedPresenter;
//    private GetBreedInteractor interactor;
//
//    @BeforeEach
//    void setUp() {
//        catDAO = mock(CatDAOInterface.class);
//        getBreedPresenter = mock(GetBreedOutputBoundary.class);
//        interactor = new GetBreedInteractor(catDAO, getBreedPresenter);
//    }
//
//    @Test
//    void testGetBreedInformationSuccess() throws Exception {
//        String breedName = "American Shorthair";
//        HashMap<String, Object> breedInfo = new HashMap<>();
//        breedInfo.put("name", "American Shorthair");
//        breedInfo.put("description", "The American Shorthair is known for its longevity, robust health, good looks, sweet personality, and amiability with children, dogs, and other pets.");
//        breedInfo.put("adaptability", 5);
//        breedInfo.put("affection_level", 5);
//        breedInfo.put("child_friendly", 4);
//        breedInfo.put("dog_friendly", 5);
//        breedInfo.put("energy_level", 3);
//        breedInfo.put("image_url", "https://cdn2.thecatapi.com/images/JFPROfGtQ.jpg");
//
//        when(catDAO.getBreedInformation(breedName)).thenReturn(breedInfo);
//
//        GetBreedInputData inputData = new GetBreedInputData(breedName);
//        GetBreedOutputData expectedOutputData = new GetBreedOutputData(
//                "American Shorthair",
//                "The American Shorthair is known for its longevity, robust health, good looks, sweet personality, and amiability with children, dogs, and other pets.",
//                "5",
//                "5",
//                "4",
//                "5",
//                "3",
//                "https://cdn2.thecatapi.com/images/JFPROfGtQ.jpg"
//        );
//
//        interactor.execute(inputData);
//
//        verify(catDAO).getBreedInformation(breedName);
//        verify(getBreedPresenter).prepareGetBreedView(any(GetBreedOutputData.class));
//        verify(getBreedPresenter).prepareGetBreedView(refEq(expectedOutputData));
//    }
//
//    @Test
//    void testGetBreedInformationSuccess_MultipleBreeds() throws Exception {
//        String breedName = "British Shorthair";
//        HashMap<String, Object> breedInfo = new HashMap<>();
//        breedInfo.put("name", "British Shorthair");
//        breedInfo.put("description", "The British Shorthair is a very pleasant cat to have as a companion, ans is easy going and placid. The British is a fiercely loyal, loving cat and will attach herself to every one of her family members. While loving to play, she doesn't need hourly attention. If she is in the mood to play, she will find someone and bring a toy to that person. The British also plays well by herself, and thus is a good companion for single people.");
//        breedInfo.put("adaptability", 5);
//        breedInfo.put("affection_level", 4);
//        breedInfo.put("child_friendly", 4);
//        breedInfo.put("dog_friendly", 5);
//        breedInfo.put("energy_level", 2);
//        breedInfo.put("image_url", "https://cdn2.thecatapi.com/images/s4wQfYoEk.jpg");
//
//        when(catDAO.getBreedInformation(breedName)).thenReturn(breedInfo);
//
//        GetBreedInputData inputData = new GetBreedInputData(breedName);
//        GetBreedOutputData expectedOutputData = new GetBreedOutputData(
//                "British Shorthair",
//                "The British Shorthair is a very pleasant cat to have as a companion, ans is easy going and placid. The British is a fiercely loyal, loving cat and will attach herself to every one of her family members. While loving to play, she doesn't need hourly attention. If she is in the mood to play, she will find someone and bring a toy to that person. The British also plays well by herself, and thus is a good companion for single people.",
//                "5",
//                "4",
//                "4",
//                "5",
//                "2",
//                "https://cdn2.thecatapi.com/images/s4wQfYoEk.jpg"
//        );
//
//        interactor.execute(inputData);
//
//        verify(catDAO).getBreedInformation(breedName);
//        verify(getBreedPresenter).prepareGetBreedView(any(GetBreedOutputData.class));
//        verify(getBreedPresenter).prepareGetBreedView(refEq(expectedOutputData));
//    }
//}
