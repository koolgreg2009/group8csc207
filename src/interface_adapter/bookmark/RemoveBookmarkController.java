package interface_adapter.bookmark;

import use_case.bookmarks.BookmarkInputBoundary;
import use_case.bookmarks.BookmarkInputData;

import java.util.Scanner;

/**
 * Controller class responsible for removing bookmarks.
 */
public class RemoveBookmarkController {
    private final BookmarkInputBoundary removeBookmarkInteractor;

    /**
     * Constructs a RemoveBookmarkController with the given BookmarkInputBoundary.
     *
     * @param removeBookmarkInteractor The interactor that handles the bookmark removal logic.
     */
    public RemoveBookmarkController(BookmarkInputBoundary removeBookmarkInteractor) {
        this.removeBookmarkInteractor = removeBookmarkInteractor;
    }

    /**
     * Executes the process of removing a bookmark for a given user.
     * Prompts the user to enter the ID of the pet they want to remove the bookmark and processes the input.
     *
     * @param username The username of the user removing the bookmark.
     */
    public void execute(String username){
        Scanner scanner = new Scanner(System.in);
        // Asks user to input pet ID
        System.out.println("Enter the ID of the pet you want to remove from your bookmarks: ");
        // Reads user input
        int petID = scanner.nextInt();
        this.removeBookmarkInteractor.execute(new BookmarkInputData(username, petID));
    }
}
