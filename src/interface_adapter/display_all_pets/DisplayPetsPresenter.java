package interface_adapter.display_all_pets;

import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

public class DisplayPetsPresenter implements DisplayPetsOutputBoundary {

    public void displayPetsOutput(DisplayPetsOutputData displayPetsOutputData) {
        System.out.println(displayPetsOutputData.getPets());
    }
}
