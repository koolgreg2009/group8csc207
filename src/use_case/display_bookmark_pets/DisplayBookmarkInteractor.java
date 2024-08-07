package use_case.display_bookmark_pets;

import data_access.PetDAOInterface;
import dto.pet.PetDTO;
import entity.Bookmark;
import entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayBookmarkInteractor implements DisplayBookmarkInputBoundary{
    private final PetDAOInterface filePetDAO;
    private final DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter;

    public DisplayBookmarkInteractor(PetDAOInterface filepetDAO, DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter) {
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
        displayBookmarkPresenter.displayPetsOutput(new DisplayBookmarkPetsOutputData(petDtoList));
    }
}
