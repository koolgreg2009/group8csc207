package interface_adapter.display_bookmark_pets;

import interface_adapter.bookmark.BookmarkState;
import interface_adapter.bookmark.BookmarkViewModel;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputData;

public class DisplayBookmarkPresenter implements DisplayBookmarkPetsOutputBoundary {

    private final BookmarkViewModel bookmarkViewModel;

    public DisplayBookmarkPresenter(BookmarkViewModel bookmarkViewModel) {
        this.bookmarkViewModel = bookmarkViewModel;
    }

    @Override
    public void displayPetsOutput(DisplayBookmarkPetsOutputData displayBookmarkPetsOutputData) {
        BookmarkState bookmarkState = bookmarkViewModel.getBookmarkState();
        bookmarkState.setBookmarkDTO(displayBookmarkPetsOutputData.getBookmarks());
        bookmarkViewModel.firePropertyChanged();
    }
}
