package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * The CatBreedDAO class is responsible for fetching breed information from TheCatAPI.
 * It implements the CatDAOInterface interface and uses the OkHttpClient library to
 * perform HTTP requests.
 */
public class CatBreedDAO implements CatDAOInterface {
    private static final String API_KEY = "live_DUQgLUE2gN2cW7JxlvdupPwS1n2CyUFee5yfvYXnyUps7D6CEF9yjk6bCHdwqGiY";
    private static final String API_URL = "https://api.thecatapi.com/v1/breeds/search";
    private final OkHttpClient client = new OkHttpClient();

    /**
     * Fetches breed information for a given breed name from TheCatAPI.
     *
     * @param breedName The name of the breed to fetch information for.
     * @return A JSON string containing the breed information, or null if an error occurs.
     */
    @Override
    public String getBreedInformation(String breedName) {
        String url = API_URL + "?q=" + breedName + "&attach_image=1";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Return the JSON response as a string
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
