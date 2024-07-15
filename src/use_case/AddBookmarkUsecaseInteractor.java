package use_case;
import entity.Bookmark;
import entity.BookmarkFactory;

public class AddBookmarkUsecaseInteractor implements BookmarkInputBoundary{

    final BookmarkOutputboundary outputboundary;
    final BookmarkFactory bookmarkFactory;

    public AddBookmarkUsecaseInteractor(BookmarkOutputboundary outputboundary, BookmarkFactory bookmarkFactory) {
        this.outputboundary = outputboundary;
        this.bookmarkFactory = bookmarkFactory;
    }

    public void addBookmark(BookmarkInputData inputData) {
        // if duplicate,
    }

    public void removeBookmark(BookmarkInputData inputData) {

    }

}
