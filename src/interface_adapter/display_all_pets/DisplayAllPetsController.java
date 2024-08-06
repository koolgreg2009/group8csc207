//package interface_adapter.display_all_pets;
//
//import interface_adapter.SessionManager;
//import use_case.display.display_all_available_pets.DisplayAllPetsInputBoundary;
//import use_case.display.display_all_available_pets.DisplayAllPetsInputData;
//
//public class DisplayAllPetsController {
//    private final DisplayAllPetsInputBoundary displayAllPetsInteractor;
//
//    public DisplayAllPetsController(DisplayAllPetsInputBoundary displayAllPetsInteractor) {
//        this.displayAllPetsInteractor = displayAllPetsInteractor;
//    }
//
//    public void execute(){
//        this.displayAllPetsInteractor.execute(new DisplayAllPetsInputData(SessionManager.getCurrentUser()));
//
//    }
//}
