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
    private final String affectionLevel;
    private final String childFriendly;
    private final String dogFriendly;
    private final String energyLevel;
    private final String imgUrl;

    /**
     * Constructs a {@code GetBreedOutputData} object with the specified attributes.
     *
     * @param breedName the name of the breed
     * @param description a description of the breed
     * @param adaptability how adaptable the breed is
     * @param affectionLevel the level of affection the breed typically shows
     * @param childFriendly how friendly the breed is with children
     * @param dogFriendly how friendly the breed is with other dogs
     * @param energyLevel the energy level of the breed
     * @param imgUrl a URL to an image of the breed
     */
    public GetBreedOutputData(String breedName, String description, String adaptability, String affectionLevel,
                String childFriendly, String dogFriendly, String energyLevel, String imgUrl) {
        this.breedName = breedName;
        this.description = description;
        this.adaptability = adaptability;
        this.affectionLevel = affectionLevel;
        this.childFriendly = childFriendly;
        this.dogFriendly = dogFriendly;
        this.energyLevel = energyLevel;
        this.imgUrl = imgUrl;
    }

    /**
     * Retrieves the name of the breed.
     *
     * @return the breed name
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * Retrieves the description of the breed.
     *
     * @return the breed description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the adaptability of the breed.
     *
     * @return the breed's adaptability
     */
    public String getAdaptability() {
        return adaptability;
    }

    /**
     * Retrieves the level of affection the breed typically shows.
     *
     * @return the affection level of the breed
     */
    public String getAffectionLevel() {
        return affectionLevel;
    }

    /**
     * Retrieves how friendly the breed is with children.
     *
     * @return the breed's child friendliness
     */
    public String getChildFriendly() {
        return childFriendly;
    }

    /**
     * Retrieves how friendly the breed is with other dogs.
     *
     * @return the breed's dog friendliness
     */
    public String getDogFriendly() {
        return dogFriendly;
    }

    /**
     * Retrieves the energy level of the breed.
     *
     * @return the breed's energy level
     */
    public String getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Retrieves the URL of an image of the breed.
     *
     * @return the image URL of the breed
     */
    public String getImgUrl() {
        return imgUrl;
    }
}
