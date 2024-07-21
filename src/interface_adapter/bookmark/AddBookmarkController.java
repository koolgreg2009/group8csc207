package interface_adapter.bookmark;

import interface_adapter.SessionManager;
import use_case.bookmarks.BookmarkInputBoundary;
import use_case.bookmarks.BookmarkInputData;

import java.util.Scanner;

/**
 * Controller class responsible for adding bookmarks.
 */
public class AddBookmarkController {
    private final BookmarkInputBoundary addBookmarkInteractor;

    /**
     * Constructs an AddBookmarkController with the given BookmarkInputBoundary.
     *
     * @param addBookmarkInteractor The interactor that handles the bookmark addition logic.
     */
    public AddBookmarkController(BookmarkInputBoundary addBookmarkInteractor) {
        this.addBookmarkInteractor = addBookmarkInteractor;
    }

    /**
     * Executes the process of adding a bookmark for a given user.
     * Prompts the user to enter the ID of the pet they want to bookmark and processes the input.
     *
     */
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the pet you want to bookmark: ");
        int petID = scanner.nextInt();
        this.addBookmarkInteractor.execute(new BookmarkInputData(SessionManager.getCurrentUser(), petID));
    }
}
