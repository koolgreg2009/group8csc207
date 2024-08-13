package data_access;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;

public interface APIInfoInterface {

    List<String> getData(String key);

    void getBreedInfo() throws IOException;

    void save();
}
