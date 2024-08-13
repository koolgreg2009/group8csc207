package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entity.Pet;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FileApiInfoDAO implements APIInfoInterface{
    private final File jsonFile;
    private final String API_KEY = "Av56m5jr";
    private final Map<String, List<String>> data = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OkHttpClient client;
    private final String BASE_URL = "https://api.rescuegroups.org/v5";

    public FileApiInfoDAO(String jsonPath) throws IOException {
        jsonFile = new File(jsonPath);
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .build();
        if (jsonFile.length() == 0) {
            getBreedInfo();
            getLocation();
            save();
        }
            TypeReference<HashMap<String, List<String>>> typeRef = new TypeReference<HashMap<String, List<String>>>() {};
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            data.putAll(objectMapper.readValue(jsonFile, typeRef));

    }
    @Override
    public List<String> getData(String key){
        return data.get(key);
    }
    @Override
    public void getBreedInfo() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/public/animals/breeds/search/cats?limit=250")
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                JsonNode root = objectMapper.readTree(responseBody);
                JsonNode data = root.get("data");
                List<String> breedNames = new ArrayList<>();
                for (JsonNode node : data) {
                    String breedName = node.get("attributes").get("name").asText();
                    breedNames.add(breedName);
                }
                save("breeds", breedNames);
            } else {
                throw new IOException("Breed search failed with HTTP code: " + response.code() + " and message: " + response.message());
            }

        }
    }
    public void getLocation() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/public/animals/search/available/cats?limit=250")
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/vnd.api+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                JsonNode root = objectMapper.readTree(responseBody);
                List<String> locations = new ArrayList<>();
                JsonNode includedArray = root.path("included");
                if (includedArray.isArray()) {
                    for (JsonNode item : includedArray) {
                        if ("locations".equals(item.path("type").asText())) {
                            String cityState = item.path("attributes").path("citystate").asText();
                            if (!Objects.equals(cityState, "")) {
                                locations.add(cityState);
                            }
                        }
                    }
                }
                save("locations", locations);
            } else {
                throw new IOException("Animal search failed with HTTP code: " + response.code() + " and message: " + response.message());
            }
        }
    }
    private void save(String key, List<String> breedNames){
        data.put(key, breedNames);
        save();

    }
    private void save() {
        try {
            objectMapper.writeValue(jsonFile, data);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }



}

