package use_case.get_breed_info;

import data_access.CatDAOInterface;

public interface getBreedInputBoundary {
    void execute(getBreedInputData breedInputData);
}
