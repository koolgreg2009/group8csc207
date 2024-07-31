package interface_adapter.get_breed;

import use_case.get_breed_info.GetBreedOutputBoundary;
import use_case.get_breed_info.GetBreedOutputData;

public class GetBreedPresenter implements GetBreedOutputBoundary {
    public void prepareGetBreedView(GetBreedOutputData getBreedOutputData){
        System.out.println("Breed Name: " + getBreedOutputData.getBreedName());
        System.out.println("Description: " + getBreedOutputData.getDescription());
        System.out.println("Adaptability: " + getBreedOutputData.getAdaptability());
        System.out.println("Affection Level: " + getBreedOutputData.getAffectionLevel());
        System.out.println("Child Friendly: " + getBreedOutputData.getChildFriendly());
        System.out.println("Dog Friendly: " + getBreedOutputData.getDogFriendly());
        System.out.println("Energy Level: " + getBreedOutputData.getEnergyLevel());
        System.out.println("Image URL: " + getBreedOutputData.getImgUrl());
    }
}
