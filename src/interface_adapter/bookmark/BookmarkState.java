package interface_adapter.bookmark;

import dto.BookmarkDTO;  // honestly not sure if we need BookmarkDTO...
import dto.PetDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the state of bookmarked pets.
 */
public class BookmarkState {
    private List<PetDTO> bookmarkedPets;

    /**
     * Default constructor initializes an empty list of bookmarked pets.
     */
    public BookmarkState() {
    }

    /**
     * Copy constructor creates a new BookmarkState by copying another BookmarkState.
     *
     * @param copy the BookmarkState to copy
     */
    public BookmarkState(BookmarkState copy) {
        bookmarkedPets = copy.bookmarkedPets;
    }

    /**
     * Removes a pet from the list of bookmarked pets by its ID.
     *
     * @param petID the ID of the pet to remove
     */
    public void removeBookmark(int petID){
        bookmarkedPets.removeIf(pet -> pet.getPetID() == petID);
    }

    /**
     * Adds a new pet to the list of bookmarked pets if it is not already present.
     *
     * @param pet the PetDTO to add
     */
    public void addBookmark(PetDTO pet){
        if (!bookmarkedPets.contains(pet)) {
            bookmarkedPets.add(pet);
        }
    }

    /**
     * Checks if a pet is already bookmarked.
     *
     * @param pet the PetDTO to check
     * @return true if the pet is bookmarked, false otherwise
     */
    public boolean isBookmarked(PetDTO pet){
        return bookmarkedPets.contains(pet);
    }

    /**
     * Gets the current date and time when the pet was bookmarked.
     *
     * @param pet the PetDTO to get the bookmark time for
     * @return the current date and time as a LocalDateTime instance
     */
    public LocalDateTime getBookmarkTime(PetDTO pet){  // Should we get time from BookmarkDTO?
        return LocalDateTime.now();
    }

    /**
     * Retrieves all bookmarked pets.
     *
     * @return a list of all bookmarked pets
     */
    public List<PetDTO> getAllBookmarks(){
        return new ArrayList<>(bookmarkedPets);
    }
}
