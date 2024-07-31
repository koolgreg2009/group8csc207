package use_case.display.display_bookmark_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.Pet;
import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

import java.util.ArrayList;
import java.util.List;

public class DisplayBookmarkInteractor implements DisplayBookmarkInputBoundary{
    private final PetDAOInterface filePetDAO;
    private final DisplayPetsOutputBoundary displayBookmarkPresenter;

    public DisplayBookmarkInteractor(PetDAOInterface filepetDAO, DisplayPetsOutputBoundary displayBookmarkPresenter) {
        this.filePetDAO = filepetDAO;
        this.displayBookmarkPresenter = displayBookmarkPresenter;
    }
    public void execute(DisplayBookmarkInputData displayBookmarkInputData){
        List<Bookmark> bookmarks = displayBookmarkInputData.getBookmarks();
        List<Pet> pets = new ArrayList<>();
        for(Bookmark bookmark: bookmarks){
            pets.add(filePetDAO.get(bookmark.getPetID()));
        }
        displayBookmarkPresenter.displayAllPetsOutput(new DisplayPetsOutputData(pets));
    }
}
