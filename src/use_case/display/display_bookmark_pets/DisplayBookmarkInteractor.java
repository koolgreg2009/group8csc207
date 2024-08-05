package use_case.display.display_bookmark_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.pet.PetDTO;
import entity.Bookmark;
import entity.Pet;
import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<PetDTO> petDtoList = pets == null ? new ArrayList<>()
                : pets.stream()
                .map(pet -> new PetDTO(pet.getPetID(), pet.getName(), pet.getBreed(), pet.getGender(),
                        pet.getSpecies(), pet.getPetAge(), pet.getBio(), pet.getOwner(), pet.getEmail(),
                        pet.getPhoneNum(), pet.getActivityLevel(), pet.getLocation(), pet.getImgUrl()))
                .collect(Collectors.toList());
        petDtoList.sort((p1, p2) -> p1.getPetID() - p2.getPetID());
        displayBookmarkPresenter.displayPetsOutput(new DisplayPetsOutputData(petDtoList));
    }
}
