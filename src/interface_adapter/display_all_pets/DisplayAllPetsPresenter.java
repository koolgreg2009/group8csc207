package interface_adapter.display_all_pets;

import use_case.display_all_available_pets.DisplayAllPetsOutputBoundary;
import use_case.display_all_available_pets.DisplayAllPetsOutputData;

public class DisplayAllPetsPresenter implements DisplayAllPetsOutputBoundary {

    public void displayAllPetsOutput(DisplayAllPetsOutputData displayAllPetsOutputData) {
        System.out.println(displayAllPetsOutputData.getPets());
    }
}
