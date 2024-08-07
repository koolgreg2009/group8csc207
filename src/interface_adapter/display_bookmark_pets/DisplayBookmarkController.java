package interface_adapter.display_bookmark_pets;

import entity.Bookmark;
import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInputData;

import java.util.List;

public class DisplayBookmarkController {
    private final DisplayBookmarkInputBoundary displayBookmarkInteractor;
    public DisplayBookmarkController(DisplayBookmarkInputBoundary displayBookmarkInteractor) {
        this.displayBookmarkInteractor = displayBookmarkInteractor;
    }
    public void execute(List<Bookmark> bookmarks){
        displayBookmarkInteractor.execute(new DisplayBookmarkInputData(bookmarks));
    }
}
