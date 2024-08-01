package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * The CatBreedDAO class is responsible for fetching breed information from TheCatAPI.
 * It implements the CatDAOInterface interface and uses the OkHttpClient library to
 * perform HTTP requests.
 */
public class CatBreedDAO implements CatDAOInterface {
    private final OkHttpClient client = new OkHttpClient();
    private static final String API_KEY = "live_DUQgLUE2gN2cW7JxlvdupPwS1n2CyUFee5yfvYXnyUps7D6CEF9yjk6bCHdwqGiY";
    private static final String API_URL = "https://api.thecatapi.com/v1/breeds/search";
    /**
     * Fetches breed information for a given breed name from TheCatAPI.
     *
     * @param breedName The name of the breed to fetch information for.
     * @return A JSON string containing the breed information, or null if an error occurs.
     */
    @Override
    public HashMap<String, Object> getBreedInformation(String breedName) {
        // String url = System.getenv("API_URL") + "?q=" + breedName + "&attach_image=1";
        String url = API_URL + "?q=" + breedName + "&attach_image=1";
        Request request = new Request.Builder()
                .url(url)
//                .addHeader("x-api-key", System.getenv("API_KEY"))
                .addHeader("x-api-key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            return parseJsonResponseToMap(responseBody);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * Parses the JSON response and extracts the required fields into a HashMap.
     *
     * @param jsonResponse The JSON response as a string.
     * @return A HashMap containing the extracted information.
     */
    private HashMap<String, Object> parseJsonResponseToMap(String jsonResponse) {
        JSONArray jsonArray = new JSONArray(jsonResponse);
        if (jsonArray.isEmpty()) {
            return null;
        }
        JSONObject breed = jsonArray.getJSONObject(0);
        HashMap<String, Object> breedInfo = new HashMap<>();
        breedInfo.put("name", breed.getString("name"));
        breedInfo.put("description", breed.getString("description"));
        breedInfo.put("adaptability", breed.getInt("adaptability"));
        breedInfo.put("affection_level", breed.getInt("affection_level"));
        breedInfo.put("child_friendly", breed.getInt("child_friendly"));
        breedInfo.put("dog_friendly", breed.getInt("dog_friendly"));
        breedInfo.put("energy_level", breed.getInt("energy_level"));
        breedInfo.put("image_url", breed.getJSONObject("image").getString("url"));

        return breedInfo;
    }

    public static void main(String[] args) {
        CatBreedDAO catBreedDAO = new CatBreedDAO();

    }
}

