package data_access;

import java.io.IOException;
import java.util.List;

public interface APIInfoInterface {
    List<String> getData(String key);

    void getBreedInfo() throws IOException;
}
