package use_case.get_breed_info;

public class getBreedInputData {
    final private String breed_name;

    public getBreedInputData(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getBreedName() {
        return breed_name;
    }
}
