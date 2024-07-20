package use_case.bookmarks;

import data_access.FileUserDAO;
import entity.Bookmark;
import entity.BookmarkFactory;
import entity.user.AdopterUser;

import java.util.ArrayList;

/**
 * This is an interactor for removing a bookmark from a user's list of bookmarks.
 */

public class RemoveBookmarkInteractor implements RemoveBookmarkInputBoundary {

    final FileUserDAO userDAO;
    final RemoveBookmarkOutputBoundary removeOutputBoundary;

    /**
     * Constructs a RemoveBookmarkInteractor with the specified user DAO and output boundary.
     * @param userDAO the data access object for the user
     * @param removeOutputBoundary the output boundary to handle the output of the bookmark removal process
     */
    public RemoveBookmarkInteractor(FileUserDAO userDAO, RemoveBookmarkOutputBoundary removeOutputBoundary) {
        this.userDAO = userDAO;
        this.removeOutputBoundary = removeOutputBoundary;
    }

    /**
     * Removes a bookmark based on the input data given.
     * @param inputData the data required to remove the bookmark.
     */
    public void removeBookmark(BookmarkInputData inputData){
        // Obtain the adopter user from the inputData provided.
        AdopterUser user = ((AdopterUser) userDAO.get(inputData.getUsername()));

        //Obtain the list of all bookmarks associated with that adopter user.
        ArrayList<Bookmark> userBookmarks = (ArrayList<Bookmark>) user.getBookmarks();

        //Initializing a Bookmark object to store the bookmark that is to be removed.
        Bookmark bookmarkToRemove = null;
        for (Bookmark userBookmark : userBookmarks) {
            //found the correct bookmark to remove from all the bookmarks associated with that adopter user
            if (userBookmark.getPetID() == inputData.getPetID()){
                //save the bookmark object
                bookmarkToRemove = userBookmark;
                //break out of for loop since bookmark has been found
                break;
            }
        }
        //remove the bookmark from the list
        userBookmarks.remove(bookmarkToRemove);
        //save the information of the user back to the DAO
        userDAO.save(user);

        //TODO: create output data to feed to Presenter
    }
}