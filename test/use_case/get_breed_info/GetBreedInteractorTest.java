package use_case.get_breed_info;

import data_access.CatDAOInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GetBreedInteractorIntegrationTest {

    private CatDAOInterface catDAO;
    private GetBreedOutputBoundary getBreedPresenter;
    private GetBreedInteractor interactor;

    @BeforeEach
    void setUp() {
        catDAO = mock(CatDAOInterface.class);
        getBreedPresenter = mock(GetBreedOutputBoundary.class);
        interactor = new GetBreedInteractor(catDAO, getBreedPresenter);
    }

    @Test
    void testGetBreedInformationSuccess() {
        String breedName = "American Shorthair";
        String breedInfo = "[{\"weight\":{\"imperial\":\"8 - 15\",\"metric\":\"4 - 7\"},\"id\":\"asho\",\"name\":\"American Shorthair\",\"cfa_url\":\"http://cfa.org/Breeds/BreedsAB/AmericanShorthair.aspx\",\"vetstreet_url\":\"http://www.vetstreet.com/cats/american-shorthair\",\"vcahospitals_url\":\"https://vcahospitals.com/know-your-pet/cat-breeds/american-shorthair\",\"temperament\":\"Active, Curious, Easy Going, Playful, Calm\",\"origin\":\"United States\",\"country_codes\":\"US\",\"country_code\":\"US\",\"description\":\"The American Shorthair is known for its longevity, robust health, good looks, sweet personality, and amiability with children, dogs, and other pets.\",\"life_span\":\"15 - 17\",\"indoor\":0,\"lap\":1,\"alt_names\":\"Domestic Shorthair\",\"adaptability\":5,\"affection_level\":5,\"child_friendly\":4,\"dog_friendly\":5,\"energy_level\":3,\"grooming\":1,\"health_issues\":3,\"intelligence\":3,\"shedding_level\":3,\"social_needs\":4,\"stranger_friendly\":3,\"vocalisation\":3,\"experimental\":0,\"hairless\":0,\"natural\":1,\"rare\":0,\"rex\":0,\"suppressed_tail\":0,\"short_legs\":0,\"wikipedia_url\":\"https://en.wikipedia.org/wiki/American_Shorthair\",\"hypoallergenic\":0,\"reference_image_id\":\"JFPROfGtQ\",\"image\":{\"id\":\"JFPROfGtQ\",\"width\":1600,\"height\":1200,\"url\":\"https://cdn2.thecatapi.com/images/JFPROfGtQ.jpg\"}}]";
        when(catDAO.getBreedInformation(breedName)).thenReturn(breedInfo);

        GetBreedInputData inputData = new GetBreedInputData(breedName);

        interactor.execute(inputData);

        verify(catDAO).getBreedInformation(breedName);
        verify(getBreedPresenter).prepareGetBreedView(any(GetBreedOutputData.class));
    }

    @Test
    void testGetBreedInformationSuccess_MultipleBreeds() {
        // Given
        String breedName = "British Shorthair";
        String breedInfo = "[{\"weight\":{\"imperial\":\"12 - 20\",\"metric\":\"5 - 9\"},\"id\":\"bsho\",\"name\":\"British Shorthair\",\"cfa_url\":\"http://cfa.org/Breeds/BreedsAB/BritishShorthair.aspx\",\"vetstreet_url\":\"http://www.vetstreet.com/cats/british-shorthair\",\"vcahospitals_url\":\"https://vcahospitals.com/know-your-pet/cat-breeds/british-shorthair\",\"temperament\":\"Affectionate, Easy Going, Gentle, Loyal, Patient, calm\",\"origin\":\"United Kingdom\",\"country_codes\":\"GB\",\"country_code\":\"GB\",\"description\":\"The British Shorthair is a very pleasant cat to have as a companion, ans is easy going and placid. The British is a fiercely loyal, loving cat and will attach herself to every one of her family members. While loving to play, she doesn't need hourly attention. If she is in the mood to play, she will find someone and bring a toy to that person. The British also plays well by herself, and thus is a good companion for single people.\",\"life_span\":\"12 - 17\",\"indoor\":0,\"lap\":1,\"alt_names\":\"Highlander, Highland Straight, Britannica\",\"adaptability\":5,\"affection_level\":4,\"child_friendly\":4,\"dog_friendly\":5,\"energy_level\":2,\"grooming\":2,\"health_issues\":2,\"intelligence\":3,\"shedding_level\":4,\"social_needs\":3,\"stranger_friendly\":2,\"vocalisation\":1,\"experimental\":0,\"hairless\":0,\"natural\":1,\"rare\":0,\"rex\":0,\"suppressed_tail\":0,\"short_legs\":0,\"wikipedia_url\":\"https://en.wikipedia.org/wiki/British_Shorthair\",\"hypoallergenic\":0,\"reference_image_id\":\"s4wQfYoEk\",\"image\":{\"id\":\"s4wQfYoEk\",\"width\":1600,\"height\":1457,\"url\":\"https://cdn2.thecatapi.com/images/s4wQfYoEk.jpg\"}}]";
        when(catDAO.getBreedInformation(breedName)).thenReturn(breedInfo);

        GetBreedInputData inputData = new GetBreedInputData(breedName);

        interactor.execute(inputData);

        verify(catDAO).getBreedInformation(breedName);
        verify(getBreedPresenter).prepareGetBreedView(any(GetBreedOutputData.class));
    }
}
