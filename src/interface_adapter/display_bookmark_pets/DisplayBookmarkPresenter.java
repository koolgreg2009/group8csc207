package interface_adapter.display_bookmark_pets;

import interface_adapter.SessionManager;
import interface_adapter.bookmark.BookmarkState;
import interface_adapter.bookmark.BookmarkViewModel;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputData;

/**
 * The {@link DisplayBookmarkPresenter} class is responsible for presenting the output of bookmark display operations.
 * It updates the {@link BookmarkViewModel} with the retrieved bookmark data and notifies any observers of changes.
 */
public class DisplayBookmarkPresenter implements DisplayBookmarkPetsOutputBoundary {
    private final BookmarkViewModel bookmarkViewModel;

    /**
     * Constructs a {@link DisplayBookmarkPresenter} with the specified bookmark view model.
     *
     * @param bookmarkViewModel the view model used to update the bookmark state and notify observers
     */
    public DisplayBookmarkPresenter(BookmarkViewModel bookmarkViewModel) {
        this.bookmarkViewModel = bookmarkViewModel;
    }

    /**
     * Processes and displays the bookmark data output.
     * This method updates the {@link BookmarkState} in the {@link BookmarkViewModel} with the provided bookmark data
     * and sets the current username from {@link SessionManager}. It then triggers a notification to update any
     * observers about the changes.
     *
     * @param displayBookmarkPetsOutputData the data containing the bookmarks to be displayed
     */
    @Override
    public void displayPetsOutput(DisplayBookmarkPetsOutputData displayBookmarkPetsOutputData) {
        BookmarkState bookmarkState = bookmarkViewModel.getBookmarkState();
        bookmarkState.setBookmarkDTO(displayBookmarkPetsOutputData.getBookmarks());
        bookmarkState.setUsername(SessionManager.getInstance().getCurrentUser());
        bookmarkViewModel.firePropertyChanged();
    }
}
