package data_access;

import java.io.IOException;

public interface CatDAOInterface {
    String getBreedInformation(String breedName) throws IOException;
}
