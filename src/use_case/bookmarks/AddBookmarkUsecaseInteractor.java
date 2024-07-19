package use_case.bookmarks;
import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.BookmarkFactory;
import entity.user.AdopterUser;
import java.time.LocalDateTime;

/**
 * Interactor responsible for adding a bookmark. This handles the business logic for adding bookmarks to the account
 * of the user.
 */
public class AddBookmarkUsecaseInteractor implements BookmarkInputBoundary{

    final BookmarkOutputboundary bookmarkPresenter;
    final BookmarkFactory bookmarkFactory;
    final UserDAOInterface fileUserDAO;

    /**
     * Constructor for AddBookmarkUsecaseInteractor, which includes the bookmark output boundary, bookmark factory and
     * the file data access object for users.
     *
     * @param outputboundary the output boundary to send results to presenter
     * @param bookmarkFactory the factory to create a new bookmark
     * @param fileUserDAO the data access object for the user data
     */
    public AddBookmarkUsecaseInteractor(BookmarkOutputboundary outputboundary, BookmarkFactory bookmarkFactory, FileUserDAO fileUserDAO) {
        this.bookmarkPresenter = outputboundary;
        this.bookmarkFactory = bookmarkFactory;
        this.fileUserDAO = fileUserDAO;
    }

    /**
     * Adds a bookmark for a user. This also gives an error message if bookmark is already created.
     *
     * @param inputData the input data containing the username and pet ID
     */
    public void addBookmark(BookmarkInputData inputData) {
        // check for if duplicate. if duplicate, send present failed else:
        if (fileUserDAO.userHasBookmark(inputData.getUsername(), inputData.getPetID())) {
            // prepare fail view
            this.bookmarkPresenter.prepareErrorView("Bookmark already exists");
        } else{
            LocalDateTime now = LocalDateTime.now();
            Bookmark bookmark = this.bookmarkFactory.create(inputData.getPetID(), now);
            // get adapter use, append into array list
            AdopterUser user = ((AdopterUser) fileUserDAO.get(inputData.getUsername()));
            user.addBookmark(bookmark);
            fileUserDAO.save(user);

            // create output data
            // feed to presenter
        }

    }


}

