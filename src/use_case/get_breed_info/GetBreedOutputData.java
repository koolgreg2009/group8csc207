package use_case.get_breed_info;

/**
 * Encapsulates the output data for retrieving breed information.
 *
 * <p>This class stores breed information in JSON format and provides a method to access this data.
 * Note that the format of the breed data may be updated in a future phase of development.
 */
public class GetBreedOutputData {
    private final String breed_json; // will change in phase 2 to be properly formatted

    /**
     * Constructs a {@code GetBreedOutputData} object with the specified breed information in JSON format.
     *
     * @param breedJson the breed information in JSON format
     */
    public GetBreedOutputData(String breed_json) {
        this.breed_json = breed_json;
    }

    /**
     * Returns the breed information in JSON format.
     *
     * @return the breed information as a JSON string
     */
    public String getBreedJson() {
        return breed_json;
    }
}
