package view;

import dto.BookmarkDTO;
import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.BookmarkState;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.bookmark.RemoveBookmarkController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.preference.PreferenceViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Represents a view that holds all the bookmarks the user has in the application.
 * This view displays all the user's bookmarks that they can interact with.
 * It implements {@link PropertyChangeListener} to respond to property changes in the
 * {@link BookmarkViewModel} and {@link PetActionView} for handling pet-related actions.
 */
public class BookmarkView extends JPanel implements PropertyChangeListener, PetActionView {

    public final String viewName = "bookmark";

    private final LoggedInViewModel loggedInViewModel;
    private final BookmarkViewModel bookmarkViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final NotifViewModel notifViewModel;

    private final PetBioController petBioController;
    private final AdoptController adoptController;
    private final AddBookmarkController addBookmarkController;
    private final RemoveBookmarkController removeBookmarkController;

    JPanel pageBody = new JPanel();
    JLabel username = new JLabel();
    final JButton notifButton = new JButton();
    final JButton prefButton = new JButton();
    final JButton logoutButton = new JButton();
    final JButton homeButton = new JButton();

    /**
     * Constructs a {@code BookmarkView} with the specified view models and controllers.
     *
     * <p>This constructor initializes the view with all necessary models and controllers
     * required to manage bookmarks, user sessions, preferences, and notifications. It also sets up the
     * the overall page layout and UI components like buttons and labels. It attaches the appropriate
     * action listeners to the buttons to handle user interactions.</p>
     *
     * @param bookmarkViewModel the view model for bookmarks
     * @param loggedInViewModel the view model for the logged-in user
     * @param preferenceViewModel the view model for user preferences
     * @param loginViewModel the view model for managing login state
     * @param viewManagerModel the model managing the active view in the application
     * @param notifViewModel the view model for notifications
     * @param petBioController the controller for displaying pet biographies
     * @param adoptController the controller for handling pet adoption actions
     * @param removeBookmarkController the controller for removing bookmarks
     * @param addBookmarkController the controller for adding bookmarks
     */
    public BookmarkView(BookmarkViewModel bookmarkViewModel,
                        LoggedInViewModel loggedInViewModel,
                        PreferenceViewModel preferenceViewModel,
                        LoginViewModel loginViewModel,
                        ViewManagerModel viewManagerModel,
                        NotifViewModel notifViewModel,
                        PetBioController petBioController,
                        AdoptController adoptController,
                        RemoveBookmarkController removeBookmarkController,
                        AddBookmarkController addBookmarkController) {

        this.bookmarkViewModel = bookmarkViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.preferenceViewModel = preferenceViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
        this.notifViewModel = notifViewModel;
        this.petBioController = petBioController;
        this.adoptController = adoptController;
        this.removeBookmarkController = removeBookmarkController;
        this.addBookmarkController = addBookmarkController;
        this.bookmarkViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Bookmark Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel usernameInfo = new JLabel("Currently logged in: " + bookmarkViewModel.getLoggedInUser());
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        notifButton.setText(bookmarkViewModel.NOTIF_BUTTON_LABEL);
        homeButton.setText(bookmarkViewModel.HOME_BUTTON_LABEL);
        prefButton.setText(bookmarkViewModel.PREF_BUTTON_LABEL);
        logoutButton.setText(bookmarkViewModel.LOGOUT_BUTTON_LABEL);
        buttonPanel.add(notifButton);
        buttonPanel.add(homeButton);
        buttonPanel.add(prefButton);
        buttonPanel.add(logoutButton);

        pageBody.setLayout(new GridLayout(0,3));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttonPanel);
        JScrollPane bodyScrollPane = new JScrollPane(pageBody);
        this.add(bodyScrollPane);

        notifButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                notifsActionPerformed(evt);
            }
        });

        prefButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myPreferencesActionPerformed(evt);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
    }

    /**
     * Handles the action performed when the notifications button is clicked.
     *
     * @param evt the action event
     */
    private void notifsActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(notifViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the action performed when the preferences button is clicked.
     *
     * @param evt the action event
     */
    private void myPreferencesActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(preferenceViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the action performed when the logout button is clicked.
     *
     * @param evt the action event
     */
    private void logoutActionPerformed(ActionEvent evt) {
        SessionManager.getInstance().logout();
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the action performed when the home button is clicked.
     *
     * @param evt the action event
     */
    private void homeActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Displays a notification message based on the current bookmark state.
     */
    private void showNotification() {
        BookmarkState bookmarkState = bookmarkViewModel.getBookmarkState();
        if (bookmarkState.isNotificationSuccess()) {
            JOptionPane.showMessageDialog(this, bookmarkState.getNotificationMessage(),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, bookmarkState.getNotificationMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Called when a property change event occurs. This method updates the view based on the property change.
     *
     * <p>If the property name is "Bookmark State", it updates the bookmark listings in the view by
     * retrieving the updated list of bookmarks and displaying them. If the property name is "notification",
     * it shows a notification message to the user.</p>
     *
     * @param evt the property change event containing details of the change
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("bookmark")) {
            BookmarkState bookmarkState = (BookmarkState) evt.getNewValue();
            username.setText(bookmarkState.getUsername());
            List<BookmarkDTO> bookmarks = bookmarkState.getAllBookmarks();
            pageBody.removeAll();
            for (BookmarkDTO bookmark: bookmarks) {
                pageBody.add(new PetListingPanel(this, bookmark.getPet(), false));
            }
            pageBody.revalidate();
            pageBody.repaint();
        }
        else if ("notification".equals(evt.getPropertyName())) {
            BookmarkState bookmarkState = (BookmarkState) evt.getNewValue();
            List<BookmarkDTO> bookmarks = bookmarkState.getAllBookmarks();
            pageBody.removeAll();
            for (BookmarkDTO bookmark: bookmarks) {
                pageBody.add(new PetListingPanel(this, bookmark.getPet(), false));
            }
            this.revalidate();
            showNotification();
        }
    }

    /**
     * Adds a bookmark for the specified pet.
     *
     * <p>This method delegates the task of adding a bookmark to the {@link AddBookmarkController}.</p>
     *
     * @param petID the ID of the pet to be bookmarked
     */
    @Override
    public void add(int petID) {
        addBookmarkController.execute(petID);
    }

    /**
     * Removes a bookmark for the specified pet.
     *
     * <p>This method delegates the task of removing a bookmark to the {@link RemoveBookmarkController}.</p>
     *
     * @param petID the ID of the pet whose bookmark is to be removed
     */
    @Override
    public void remove(int petID){
        removeBookmarkController.execute(petID);
    }

    /**
     * Displays the details of a pet.
     *
     * <p>This method delegates the task of showing pet details to the {@link PetBioController}.</p>
     *
     * @param petID the ID of the pet whose details are to be displayed
     */
    @Override
    public void goDetail(int petID) {
        petBioController.execute(bookmarkViewModel.getLoggedInUser(), petID);
    }

    /**
     * Initiates the adoption process for a specified pet.
     *
     * <p>This method delegates the task of adopting a pet to the {@link AdoptController}.</p>
     *
     * @param petID the ID of the pet to be adopted
     */
    @Override
    public void adopt(int petID) {
        adoptController.execute(petID);
    }
}
