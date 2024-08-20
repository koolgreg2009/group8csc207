package use_case.bookmarks;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import dto.BookmarkDTO;
import dto.PetDTO;
import entity.Bookmark;
import entity.Pet;
import entity.user.AdopterUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is an interactor for removing a bookmark from a user's list of bookmarks.
 */

public class RemoveBookmarkInteractor implements BookmarkInputBoundary {

    final UserDAOInterface userDAO;
    final RemoveBookmarkOutputBoundary removeOutputBoundary;
    private final PetDAOInterface filePetDAO;

    /**
     * Constructs a {@code RemoveBookmarkInteractor} with the specified data access objects and output boundary.
     *
     * @param userDAO              the data access object for managing user-related operations
     * @param removeOutputBoundary the output boundary responsible for handling the results of the bookmark removal
     *                             process
     * @param filePetDAO           the data access object for managing pet-related operations
     */
    public RemoveBookmarkInteractor(UserDAOInterface userDAO, RemoveBookmarkOutputBoundary removeOutputBoundary,
                                    PetDAOInterface filePetDAO) {
        this.userDAO = userDAO;
        this.removeOutputBoundary = removeOutputBoundary;
        this.filePetDAO = filePetDAO;
    }

    /**
     * Executes the removal of a bookmark based on the provided input data.
     *
     * This method retrieves the user and their bookmarks from the data access object, identifies the bookmark to be
     * removed based on the pet ID, and updates the user's bookmark list accordingly. It then constructs the output data
     * including the updated list of bookmarks and prepares the success view using the output boundary.
     *
     * @param inputData the data required to remove the bookmark, which includes the username and the pet ID of the
     *                  bookmark to be removed
     */
    public void execute(BookmarkInputData inputData){
        AdopterUser user = ((AdopterUser) userDAO.get(inputData.getUsername()));
        ArrayList<Bookmark> userBookmarks = (ArrayList<Bookmark>) user.getBookmarks();
        Bookmark bookmarkToRemove = null;
        for (Bookmark userBookmark : userBookmarks) {
            if (userBookmark.getPetID() == inputData.getPetID()){
                bookmarkToRemove = userBookmark;
                break;
            }
        }

        userBookmarks.remove(bookmarkToRemove);
        userDAO.save(user);
        List<Pet> pets = new ArrayList<>();
        List<LocalDateTime> times = new ArrayList<>();
        for(Bookmark bookmark: user.getBookmarks()){
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
        List<BookmarkDTO> bookmarkDTO = new ArrayList<>();
        for(int i=0; i<pets.size(); i++){
            bookmarkDTO.add(new BookmarkDTO(petDtoList.get(i), times.get(i)));
        }

        BookmarkOutputData bookmarkOutputData = new BookmarkOutputData(userBookmarks, bookmarkToRemove, bookmarkDTO, user.getUsername());
        this.removeOutputBoundary.prepareSuccessView(bookmarkOutputData);
    }
}
