package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class for interacting with the RescueGroups API and managing local JSON file operations.
 */
public abstract class RescueAPIAbstract {
    protected final File jsonFile;
    protected final String API_KEY = "Av56m5jr";
    protected final String BASE_URL = "https://api.rescuegroups.org/v5";
    protected final OkHttpClient client;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Constructs a {@link RescueAPIAbstract} instance with the specified JSON file path.
     * Sets up an HTTP client with custom timeouts.
     *
     * @param jsonPath the path to the JSON file for storing or retrieving data.
     * @throws IOException if an I/O error occurs while initializing the file.
     */
    protected RescueAPIAbstract(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Makes a GET request to the specified API endpoint and returns the response body as a string.
     *
     * @param endpoint the API endpoint to call.
     * @return the response body as a string.
     * @throws IOException if the API call fails or the response cannot be read.
     */
    protected String makeAPICall(String endpoint) throws IOException {
        Request request = new Request.Builder()
                .url(getBaseURL() + endpoint)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String a = response.body().string();
                return a;
            } else {
                throw new IOException("API call failed with HTTP code: " + response.code() + " and message: " + response.message());
            }
        }
    }

    /**
     * Returns the base URL for API requests.
     *
     * @return the base URL as a string.
     */
    protected String getBaseURL(){
        return BASE_URL;
    }

    /**
     * Returns the {@link ObjectMapper} instance used for JSON processing.
     *
     * @return the {@link ObjectMapper} instance.
     */
    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
