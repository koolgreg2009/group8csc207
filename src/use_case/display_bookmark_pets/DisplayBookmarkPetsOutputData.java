package use_case.display_bookmark_pets;

import java.util.List;

import dto.BookmarkDTO;
import dto.PetDTO;

/**
 * Encapsulates the output data required to display all pets.
 * <p>
 * This class stores a list of pets and provides a method to access this list.
 */
public class DisplayBookmarkPetsOutputData {
    private final List<BookmarkDTO> bookmarks;

    /**
     * Constructs a {@code DisplayAllPetsOutputData} object with the specified list of pets.
     *
     * @param bookmarks the list of bookmarkDTOs to be displayed
     */
    public DisplayBookmarkPetsOutputData(List<BookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    /**
     * Returns the list of pets to be displayed.
     *
     * @return the list of pets
     */
    public List<BookmarkDTO> getBookmarks() {
        return bookmarks;
    }
}
