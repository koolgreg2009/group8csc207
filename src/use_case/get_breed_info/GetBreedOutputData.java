package use_case.get_breed_info;

public class GetBreedOutputData {
    private final String breedName;
    private final String description;
    private final String adaptability;
    private final String affection_level;
    private final String child_friendly;
    private final String dog_friendly;
    private final String energy_level;
    private final String img_url;



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
