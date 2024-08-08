//package data_access;
//
//import okhttp3.Call;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class CatBreedDAOTest {
//
//    @Mock
//    private OkHttpClient mockClient;
//
//    @InjectMocks
//    private CatBreedDAO catBreedDAO;
//
//    @Mock
//    private Call mockCall;
//
//    @Mock
//    private Response mockResponse;
//
//    @Mock
//    private ResponseBody mockResponseBody;
//
//    @BeforeEach
//    void setUp() {
//        // Replace the client in CatBreedDAO with the mocked one
//        catBreedDAO = new CatBreedDAO(mockClient);
//    }
//
//    @Test
//    void testGetBreedInformationSuccess() throws IOException {
//        // Given
//        String breedName = "American Shorthair";
//        String jsonResponse = "[{\"weight\":{\"imperial\":\"8 - 15\",\"metric\":\"4 - 7\"},\"id\":\"asho\",\"name\":\"American Shorthair\",\"cfa_url\":\"http://cfa.org/Breeds/BreedsAB/AmericanShorthair.aspx\",\"vetstreet_url\":\"http://www.vetstreet.com/cats/american-shorthair\",\"vcahospitals_url\":\"https://vcahospitals.com/know-your-pet/cat-breeds/american-shorthair\",\"temperament\":\"Active, Curious, Easy Going, Playful, Calm\",\"origin\":\"United States\",\"country_codes\":\"US\",\"country_code\":\"US\",\"description\":\"The American Shorthair is known for its longevity, robust health, good looks, sweet personality, and amiability with children, dogs, and other pets.\",\"life_span\":\"15 - 17\",\"indoor\":0,\"lap\":1,\"alt_names\":\"Domestic Shorthair\",\"adaptability\":5,\"affection_level\":5,\"child_friendly\":4,\"dog_friendly\":5,\"energy_level\":3,\"grooming\":1,\"health_issues\":3,\"intelligence\":3,\"shedding_level\":3,\"social_needs\":4,\"stranger_friendly\":3,\"vocalisation\":3,\"experimental\":0,\"hairless\":0,\"natural\":1,\"rare\":0,\"rex\":0,\"suppressed_tail\":0,\"short_legs\":0,\"wikipedia_url\":\"https://en.wikipedia.org/wiki/American_Shorthair\",\"hypoallergenic\":0,\"reference_image_id\":\"JFPROfGtQ\",\"image\":{\"id\":\"JFPROfGtQ\",\"width\":1600,\"height\":1200,\"url\":\"https://cdn2.thecatapi.com/images/JFPROfGtQ.jpg\"}}]";
//        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);
//        when(mockCall.execute()).thenReturn(mockResponse);
//        when(mockResponse.isSuccessful()).thenReturn(true);
//        when(mockResponse.body()).thenReturn(mockResponseBody);
//        when(mockResponseBody.string()).thenReturn(jsonResponse);
//
//        // When
//        String result = catBreedDAO.getBreedInformation(breedName);
//
//        // Then
//        assertEquals(jsonResponse, result);
//        verify(mockClient).newCall(any(Request.class));
//        verify(mockCall).execute();
//    }
//
//    @Test
//    void testGetBreedInformationFailure() throws IOException {
//        // Given
//        String breedName = "NonExistentBreed";
//        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);
//        when(mockCall.execute()).thenReturn(mockResponse);
//        when(mockResponse.isSuccessful()).thenReturn(false);
//
//        // When
//        String result = catBreedDAO.getBreedInformation(breedName);
//
//        // Then
//        assertEquals(null, result);
//        verify(mockClient).newCall(any(Request.class));
//        verify(mockCall).execute();
//    }
//
//    @Test
//    void testGetBreedInformationException() throws IOException {
//        // Given
//        String breedName = "AnotherBreed";
//        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);
//        when(mockCall.execute()).thenThrow(new IOException("Network error"));
//
//        // When
//        String result = catBreedDAO.getBreedInformation(breedName);
//
//        // Then
//        assertEquals(null, result);
//        verify(mockClient).newCall(any(Request.class));
//        verify(mockCall).execute();
//    }
//}
