package use_case.get_breed_info;

/**
 * Encapsulates the input data required to retrieve breed information.
 *
 * <p>This class stores the name of the breed and provides a method to access this breed name.
 */
public class GetBreedInputData {
    final private String breed_name;

    /**
     * Constructs a {@code GetBreedInputData} object with the specified breed name.
     *
     * @param breedName the name of the breed to be retrieved
     */
    public GetBreedInputData(String breed_name) {
        this.breed_name = breed_name;
    }

    /**
     * Returns the name of the breed.
     *
     * @return the breed name
     */
    public String getBreedName() {
        return breed_name;
    }
}
