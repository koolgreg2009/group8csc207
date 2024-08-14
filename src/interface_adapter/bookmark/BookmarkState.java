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
    private String username = "";
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
     * Sets the list of {@link BookmarkDTO} objects.
     *
     * @param bookmarks the list of {@link BookmarkDTO} objects to be set
     */
    public void setBookmarkDTO(List<BookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
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
     * Retrieves the username of the logged-in user that has the bookmarks
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Retrieves the notification message.
     *
     * @return the notification message
     */
    public String getNotificationMessage() {
        return notifMessage;
    }

    /**
     * Sets the notification message.
     *
     * @param notifMessage the notification message to set
     */
    public void setNotifMessage(String notifMessage) {
        this.notifMessage = notifMessage;
    }

    /**
     * Checks if the notification was successful.
     *
     * @return true if the notification was successful, false otherwise
     */
    public boolean isNotificationSuccess() {
        return notifSuccess;
    }

    /**
     * Sets the notification success status.
     *
     * @param notifSuccess the notification success status to set
     */
    public void setNotifSuccess(boolean notifSuccess) {
        this.notifSuccess = notifSuccess;
    }
}
