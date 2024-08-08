package interface_adapter.adopt;

import use_case.adopt.AdoptInputBoundary;
import use_case.adopt.AdoptInputData;

import java.util.Scanner;

/** Class AdoptController that takes in information and executes
 */
public class AdoptController {
    private final AdoptInputBoundary adoptInteractor;

    public AdoptController(AdoptInputBoundary adoptInteractor) {
        this.adoptInteractor = adoptInteractor;
    }

    public void execute(int petID){
        this.adoptInteractor.execute(new AdoptInputData(petID));
    }
}
