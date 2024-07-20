package interface_adapter.pet_bio;

import java.util.Scanner;

import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInputData;

public class PetBioController {
    private final PetBioInputBoundary petBioInteractor;

    public PetBioController(PetBioInputBoundary petBioInteractor) {
        this.petBioInteractor = petBioInteractor;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter petID");
        int petID = scanner.nextInt();
        this.petBioInteractor.execute(new PetBioInputData(petID));
        scanner.close();
    }
}

