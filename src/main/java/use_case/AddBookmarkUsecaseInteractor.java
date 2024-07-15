package use_case;
import entity.bookmark.Bookmark;
import entity.bookmark.BookmarkFactory;

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
