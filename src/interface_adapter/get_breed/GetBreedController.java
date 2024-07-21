package interface_adapter.get_breed;
import java.util.Scanner;

import use_case.get_breed_info.GetBreedInputBoundary;
import use_case.get_breed_info.GetBreedInputData;

public class GetBreedController {
    private final GetBreedInputBoundary getBreedInteractor;

    public GetBreedController(GetBreedInputBoundary getBreedInteractor) {
        this.getBreedInteractor = getBreedInteractor;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter breed");
        String breed = scanner.nextLine();
        System.out.println("Running getbreed usecase.");
        this.getBreedInteractor.execute(new GetBreedInputData(breed));
    }
}
