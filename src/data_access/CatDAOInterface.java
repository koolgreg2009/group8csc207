package data_access;

import java.util.HashMap;

public interface CatDAOInterface {

    HashMap<String, Object> getBreedInformation(String breedName);

}
