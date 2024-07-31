package interface_adapter.get_breed;

import use_case.get_breed_info.GetBreedOutputBoundary;
import use_case.get_breed_info.GetBreedOutputData;

public class GetBreedPresenter implements GetBreedOutputBoundary {
    public void prepareGetBreedView(GetBreedOutputData getBreedOutputData){
        System.out.println("Breed Name: " + getBreedOutputData.getBreedName());
        System.out.println("Description: " + getBreedOutputData.getDescription());
        System.out.println("Adaptability: " + getBreedOutputData.getAdaptability());
        System.out.println("Affection Level: " + getBreedOutputData.getAffection_level());
        System.out.println("Child Friendly: " + getBreedOutputData.getChild_friendly());
        System.out.println("Dog Friendly: " + getBreedOutputData.getDog_friendly());
        System.out.println("Energy Level: " + getBreedOutputData.getEnergy_level());
        System.out.println("Image URL: " + getBreedOutputData.getImg_url());
    }
}
