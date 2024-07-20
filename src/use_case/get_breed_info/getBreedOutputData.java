package use_case.get_breed_info;

public class getBreedOutputData {
    private final String breed_json; // will change in phase 2 to be properly formatted

    public getBreedOutputData(String breed_json) {
        this.breed_json = breed_json;
    }
    public String getBreedJson() {
        return breed_json;
    }
}
