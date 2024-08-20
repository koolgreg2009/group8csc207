package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

public abstract class RescueAPIAbstract {
    protected final File jsonFile;
    protected final String API_KEY = "Av56m5jr";
    protected final String BASE_URL = "https://api.rescuegroups.org/v5";
    protected final OkHttpClient client;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected RescueAPIAbstract(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .build();
    }
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
    protected String getBaseURL(){
        return BASE_URL;
    }
    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
