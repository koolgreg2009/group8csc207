package interface_adapter.bookmark;

import dto.PetDTO;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import view.ViewManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ViewModel for managing bookmarks.
 */
public class BookmarkViewModel extends ViewModel {
    public final String PREF_BUTTON_LABEL = "My Preferences";
    public final String HOME_BUTTON_LABEL = "Home Page";
    public final String LOGOUT_BUTTON_LABEL = "Logout";
    public final String NOTIF_BUTTON_LABEL = "Notifications";

    private BookmarkState bookmarkState = new BookmarkState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructor for BookmarkViewModel.
     */
    public BookmarkViewModel() {
        super("bookmark");
    }

    /**
     * Sets a new BookmarkState.
     *
     * @param newState the new BookmarkState
     */
    public void setState(BookmarkState newState){
        this.bookmarkState = newState;
    }

    /**
     * Notifies listeners of state changes.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("Bookmark State", null,this.bookmarkState);
    }

    /**
     * Adds a PropertyChangeListener.
     *
     * @param listener the PropertyChangeListener to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes a PropertyChangeListener.
     *
     * @param listener the PropertyChangeListener to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * Retrieves all bookmarked pets.
     *
     * @return a list of all bookmarked pets
     */
    public List<PetDTO> getAllBookmarks(){
        return bookmarkState.getAllBookmarks();
    }

    /**
     * Adds a new pet to the list of bookmarked pets if it is not already present.
     *
     * @param pet the PetDTO to add
     */
    public void addBookmark(PetDTO pet){
        bookmarkState.addBookmark(pet);
        firePropertyChanged();
    }

    /**
     * Removes a pet from the list of bookmarked pets.
     *
     * @param pet the PetDTO to remove
     */
    public void removeBookmark(PetDTO pet){
        bookmarkState.removeBookmark(pet.getPetID());
        firePropertyChanged();
    }

    /**
     * Checks if a pet is already bookmarked.
     *
     * @param pet the PetDTO to check
     * @return true if the pet is bookmarked, false otherwise
     */
    public boolean isBookmarked(PetDTO pet){
        return bookmarkState.isBookmarked(pet);
    }

    /**
     * Gets the current date and time when the pet was bookmarked.
     *
     * @param pet the PetDTO to get the bookmark time for
     * @return the current date and time as a LocalDateTime instance
     */
    public LocalDateTime getBookmarkTime(PetDTO pet){
        return bookmarkState.getBookmarkTime(pet);
    }
}
