package use_case.display_bookmark_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.PetDTO;
import entity.Bookmark;
import entity.Pet;
import entity.user.AdopterUser;
import entity.user.User;
import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInputData;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputData;
import dto.BookmarkDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayBookmarkInteractor implements DisplayBookmarkInputBoundary {
    private final PetDAOInterface filePetDAO;
    private final DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter;
    private final UserDAOInterface userDAO;

    public DisplayBookmarkInteractor(UserDAOInterface userDAO, PetDAOInterface filepetDAO, DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter) {
        this.filePetDAO = filepetDAO;
        this.displayBookmarkPresenter = displayBookmarkPresenter;
        this.userDAO = userDAO;
    }
    public void execute(DisplayBookmarkInputData displayBookmarkInputData){
        AdopterUser user = (AdopterUser)userDAO.get(displayBookmarkInputData.getUsername());
        List<Bookmark> bookmarks = user.getBookmarks();
        List<Pet> pets = new ArrayList<>();
        List<LocalDateTime> times = new ArrayList<>();
        for(Bookmark bookmark: bookmarks){
            pets.add(filePetDAO.get(bookmark.getPetID()));
            times.add(bookmark.getBookmarkedDate());
        }
        List<PetDTO> petDtoList = pets == null ? new ArrayList<>()
                : pets.stream()
                .map(pet -> new PetDTO(pet.getPetID(), pet.getName(), pet.getBreed(), pet.getGender(),
                        pet.getSpecies(), pet.getPetAge(), pet.getBio(), pet.getOwner(), pet.getEmail(),
                        pet.getPhoneNum(), pet.getActivityLevel(), pet.getLocation(), pet.getImgUrl()))
                .collect(Collectors.toList());
        petDtoList.sort((p1, p2) -> p1.getPetID() - p2.getPetID());
        List<BookmarkDTO> bookmarkDTOs = new ArrayList<>();
        for(int i=0; i<pets.size(); i++){
            bookmarkDTOs.add(new BookmarkDTO(pets.get(i), times.get(i)));
        }
        displayBookmarkPresenter.displayPetsOutput(new DisplayBookmarkPetsOutputData(bookmarkDTOs));
    }
}
