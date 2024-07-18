package use_case.bookmarkUsecase;
import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.BookmarkFactory;
import entity.User.User;
import entity.User.AdopterUser;
import java.time.LocalDateTime;

public class AddBookmarkUsecaseInteractor implements BookmarkInputBoundary{

    final BookmarkOutputboundary bookmarkPresenter;
    final BookmarkFactory bookmarkFactory;
    final UserDAOInterface fileUserDAO;

    public AddBookmarkUsecaseInteractor(BookmarkOutputboundary outputboundary, BookmarkFactory bookmarkFactory, FileUserDAO fileUserDAO) {
        this.bookmarkPresenter = outputboundary;
        this.bookmarkFactory = bookmarkFactory;
        this.fileUserDAO = fileUserDAO;
    }

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

