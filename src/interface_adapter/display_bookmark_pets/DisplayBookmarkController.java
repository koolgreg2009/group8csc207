package interface_adapter.display_bookmark_pets;

import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInputData;

public class DisplayBookmarkController {
    private final DisplayBookmarkInputBoundary displayBookmarkInteractor;
    public DisplayBookmarkController(DisplayBookmarkInputBoundary displayBookmarkInteractor) {
        this.displayBookmarkInteractor = displayBookmarkInteractor;
    }
    public void execute(String username){
        displayBookmarkInteractor.execute(new DisplayBookmarkInputData(username));
    }
}
