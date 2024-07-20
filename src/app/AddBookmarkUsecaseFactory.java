package app;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.AddBookmarkPresenter;
import use_case.bookmarks.*;

import javax.swing.*;
import java.io.IOException;

public class AddBookmarkUsecaseFactory {
    private AddBookmarkUsecaseFactory() {
    }

    public static AddBookmarkController createAddBookmarkUsecase() {
        try {
            UserDAOInterface userDAO = new FileUserDAO("./users.json");
            AddBookmarkOutputBoundary bookmarkPresenter = new AddBookmarkPresenter();
            BookmarkInputBoundary AddBookmarkInteractor = new AddBookmarkInteractor(bookmarkPresenter, userDAO);
            return new AddBookmarkController(AddBookmarkInteractor);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            return null;
        }

    }

}