package interface_adapter.get_breed;

import interface_adapter.pet_bio.PetBioState;
import interface_adapter.pet_bio.PetBioViewModel;
import use_case.get_breed_info.GetBreedOutputBoundary;
import use_case.get_breed_info.GetBreedOutputData;

public class GetBreedPresenter implements GetBreedOutputBoundary {
    private final PetBioViewModel petBioViewModel;

    public GetBreedPresenter(PetBioViewModel petBioViewModel) {
        this.petBioViewModel = petBioViewModel;
    }
    public void prepareGetBreedView(GetBreedOutputData getBreedOutputData){
        PetBioState state = petBioViewModel.getState();
        state.setNotification("Breed Name: " + getBreedOutputData.getBreedName() + "\n" +
                "Description: " + getBreedOutputData.getDescription() + "\n" +
                "Adaptability: " + getBreedOutputData.getAdaptability() + "\n" +
                "Affection Level: " + getBreedOutputData.getAffectionLevel() + "\n" +
                "Child Friendly: " + getBreedOutputData.getChildFriendly() + "\n" +
                "Dog Friendly: " + getBreedOutputData.getDogFriendly() + "\n" +
                "Energy Level: " + getBreedOutputData.getEnergyLevel() + "\n" +
                "Image URL: " + getBreedOutputData.getImgUrl());

        petBioViewModel.fireNotificationChanged();

    }

    public void prepareFailView(String errorMessage){
        PetBioState state = petBioViewModel.getState();
        state.setNotification(errorMessage);
        petBioViewModel.fireNotificationChanged();
    }
}
