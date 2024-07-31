package use_case.bookmarks;

import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.user.AdopterUser;

import java.util.ArrayList;

/**
 * This is an interactor for removing a bookmark from a user's list of bookmarks.
 */

public class RemoveBookmarkInteractor implements BookmarkInputBoundary {

    final UserDAOInterface userDAO;
    final RemoveBookmarkOutputBoundary removeOutputBoundary;

    /**
     * Constructs a RemoveBookmarkInteractor with the specified user DAO and output boundary.
     * @param userDAO the data access object for the user
     * @param removeOutputBoundary the output boundary to handle the output of the bookmark removal process
     */
    public RemoveBookmarkInteractor(UserDAOInterface userDAO, RemoveBookmarkOutputBoundary removeOutputBoundary) {
        this.userDAO = userDAO;
        this.removeOutputBoundary = removeOutputBoundary;
    }

    /**
     * Executes the removal a bookmark based on the input data given.
     * @param inputData the data required to remove the bookmark.
     */
    public void execute(BookmarkInputData inputData){
        AdopterUser user = ((AdopterUser) userDAO.get(inputData.getUsername()));
        ArrayList<Bookmark> userBookmarks = (ArrayList<Bookmark>) user.getBookmarks();
        Bookmark bookmarkToRemove = null;
        for (Bookmark userBookmark : userBookmarks) {
            if (userBookmark.getPetID() == inputData.getPetID()){
                bookmarkToRemove = userBookmark;
                break;
            }
        }

        userBookmarks.remove(bookmarkToRemove);
        userDAO.save(user);

        BookmarkOutputData bookmarkOutputData = new BookmarkOutputData(userBookmarks, bookmarkToRemove);
        this.removeOutputBoundary.successMessage(bookmarkOutputData);
    }
}
