package data_access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.*;

public class FileApiInfoDAO extends RescueAPIAbstract implements APIInfoInterface{

    private final Map<String, List<String>> data = new HashMap<>();

    public FileApiInfoDAO(String jsonPath) throws IOException {
        super(jsonPath);
        if (jsonFile.length() == 0) {
            getBreedInfo();
            getLocation();
        }
        TypeReference<HashMap<String, List<String>>> typeRef = new TypeReference<HashMap<String, List<String>>>() {};
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        data.putAll(objectMapper.readValue(jsonFile, typeRef));

    }
    @Override
    public List<String> getData(String key) {
        return data.get(key);
    }
    /**
     * Retreives all breeds in rescuesAPI database
     * @throws IOException
     */
    @Override
    public void getBreedInfo() throws IOException{
        String response = makeAPICall("/public/animals/breeds/search/cats?limit=250");
        JsonNode root = getObjectMapper().readTree(response);
        JsonNode data = root.get("data");
        List<String> breedNames = new ArrayList<>();
        for (JsonNode node : data) {
            String breedName = node.get("attributes").get("name").asText();
            breedNames.add(breedName);
        }
        save("breeds", breedNames);
    }

    /**
     * Retrieves the 250 of cat locations in database
     * @throws IOException
     */
    @Override
    public void getLocation() throws IOException {
        String response = makeAPICall("/public/animals/search/available/cats?limit=250");
        JsonNode root = getObjectMapper().readTree(response);
        List<String> locations = new ArrayList<>();
        JsonNode includedArray = root.path("included");
        if (includedArray.isArray()) {
            for (JsonNode item : includedArray) {
                if ("locations".equals(item.path("type").asText())) {
                    String cityState = item.path("attributes").path("citystate").asText();
                    if (!Objects.equals(cityState, "") && !locations.contains(cityState)){
                        locations.add(cityState);
                    }
                }
            }
        }
        save("locations", locations);
    }
    public void save(String key, List<String> names){
        data.put(key, names);
        save();

    }
    void save() {
        try {
            getObjectMapper().writeValue(jsonFile, data);
        } catch (Exception ex) {
            System.out.print("Failed saving file [" + jsonFile.getName() + "]: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean exists(String string, String key){
        return data.get(key).contains(string);
    }

    public boolean exists(List<String> names, String key){
        for (String name : names){
            if(!data.get(key).contains(name)){
                return false;
            }
        }
        return true;
    }

}