package interface_adapter.bookmark;

import dto.BookmarkDTO;
import dto.PetDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Manages the state of bookmarked pets.
 */
public class BookmarkState {
    private List<BookmarkDTO> bookmarks;
    private String username;
    private String notifMessage;
    private boolean notifSuccess;

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
        bookmarks = copy.bookmarks;
        username = copy.username;
    }

    /**
     * Removes a pet from the list of bookmarked pets by its ID.
     *
     * @param petID the ID of the pet to remove
     */
    public void removeBookmark(int petID){
        bookmarks.removeIf(bookmark -> petID == bookmark.getPetID());
    }

    /**
     * Adds a new pet to the list of bookmarked pets if it is not already present.
     *
     * @param pet the PetDTO to add
     */
    public void addBookmark(PetDTO pet){
        if (!isBookmarked(pet)) {
            bookmarks.add(new BookmarkDTO(pet, LocalDateTime.now()));
        }
    }

    /**
     * Checks if a pet is already bookmarked.
     *
     * @param pet the PetDTO to check
     * @return true if the pet is bookmarked, false otherwise
     */
    public boolean isBookmarked(PetDTO pet){
        for (BookmarkDTO bookmark : bookmarks) {
            if (bookmark.getPet().equals(pet)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all bookmarked pets.
     *
     * @return a list of all bookmarked pets
     */
    public List<BookmarkDTO> getAllBookmarks(){
        return bookmarks;
    }

    /**
     * Retrieves the bookmark time of a specified pet.
     *
     * @param pet the PetDTO for which to get the bookmark time
     * @return the date and time when the pet was bookmarked
     * @throws IllegalArgumentException if the pet is not bookmarked
     */
    public LocalDateTime getBookmarkTime(PetDTO pet){
        for (BookmarkDTO bookmark : bookmarks) {
            if (bookmark.getPet().equals(pet)) {
                return bookmark.getBookmarkedDate();
            }
        }
        throw new IllegalArgumentException("Pet was not bookmarked");
    }

    /**
     * Retrieves the username of the logged-in user that has the bookmarks
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public String getNotificationMessage() {
        return notifMessage;
    }

    public void setNotifMessage(String notifMessage) {
        this.notifMessage = notifMessage;
    }

    public boolean isNotificationSuccess() {
        return notifSuccess;
    }

    public void setNotifSuccess(boolean notifSuccess) {
        this.notifSuccess = notifSuccess;
    }
}
