package use_case.bookmarks;

import data_access.FileUserDAO;
import entity.Bookmark;
import entity.BookmarkFactory;
import entity.user.AdopterUser;

import java.util.ArrayList;

public class RemoveBookmarkInteractor implements RemoveBookmarkInputBoundary {

    final FileUserDAO userDAO;
    final RemoveBookmarkOutputBoundary removeOutputBoundary;

    public RemoveBookmarkInteractor(FileUserDAO userDAO, RemoveBookmarkOutputBoundary removeOutputBoundary) {
        this.userDAO = userDAO;
        this.removeOutputBoundary = removeOutputBoundary;
    }
//    public AddBookmarkInteractor(BookmarkOutputBoundary outputboundary, BookmarkFactory bookmarkFactory, FileUserDAO fileUserDAO) {
//        this.bookmarkPresenter = outputboundary;
//        this.bookmarkFactory = bookmarkFactory;
//        this.fileUserDAO = fileUserDAO;

    public void execute(BookmarkInputData inputData){
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

        //TODO: create output data to feed to Presenter
    }
}