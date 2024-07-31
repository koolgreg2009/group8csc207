package use_case.get_breed_info;

/**
 * Encapsulates the output data for retrieving breed information.
 *
 * <p>This class stores breed information in JSON format and provides a method to access this data.
 * Note that the format of the breed data may be updated in a future phase of development.
 */
public class GetBreedOutputData {
    private final String breedName;
    private final String description;
    private final String adaptability;
    private final String affection_level;
    private final String child_friendly;
    private final String dog_friendly;
    private final String energy_level;
    private final String img_url;


    /**
     * Constructs a {@code GetBreedOutputData} object with the specified breed information in JSON format.
     *
     * @param breedJson the breed information in JSON format
     */
    public GetBreedOutputData(String breed_json) {
        this.breed_json = breed_json;

    public GetBreedOutputData(String breedName, String description, String adaptability, String affection_level, String child_friendly, String dog_friendly, String energy_level, String img_url) {
        this.breedName = breedName;
        this.description = description;
        this.adaptability = adaptability;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.dog_friendly = dog_friendly;
        this.energy_level = energy_level;
        this.img_url = img_url;

    }
    public String getBreedName() {
        return breedName;
    }
    public String getDescription() {
        return description;
    }
    public String getAdaptability() {
        return adaptability;
    }

    /**
     * Returns the breed information in JSON format.
     *
     * @return the breed information as a JSON string
     */
    public String getBreedJson() {
        return breed_json;
    public String getAffection_level() {
        return affection_level;
    }
    public String getChild_friendly() {
        return child_friendly;
    }
    public String getDog_friendly() {
        return dog_friendly;
    }
    public String getEnergy_level() {
        return energy_level;
    }
    public String getImg_url() {
        return img_url;
    }
}
