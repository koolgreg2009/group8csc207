package interface_adapter.bookmark;

import use_case.bookmarks.BookmarkInputBoundary;
import use_case.bookmarks.BookmarkInputData;

import java.util.Scanner;

public class AddBookmarkController {
    private final BookmarkInputBoundary addBookmarkInteractor;

    public AddBookmarkController(BookmarkInputBoundary addBookmarkInteractor) {
        this.addBookmarkInteractor = addBookmarkInteractor;
    }

    public void execute(String username){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pet ID of pet you want to bookmark: ");
        int petID = scanner.nextInt();
        this.addBookmarkInteractor.execute(new BookmarkInputData(username, petID));
    }
}
