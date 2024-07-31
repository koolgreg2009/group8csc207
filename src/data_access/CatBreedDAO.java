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
    private final OkHttpClient client = new OkHttpClient();

    /**
     * Fetches breed information for a given breed name from TheCatAPI.
     *
     * @param breedName The name of the breed to fetch information for.
     * @return A JSON string containing the breed information, or null if an error occurs.
     */
    @Override
    public String getBreedInformation(String breedName) {
        String url = System.getenv("API_URL") + "?q=" + breedName + "&attach_image=1";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", System.getenv("API_KEY"))
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
