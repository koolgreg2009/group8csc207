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
import javax.swing.border.BevelBorder;
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
 * {@link BookmarkViewModel}, {@link PetActionView} for handling pet-related actions,
 * and {@link ActionListener} for button click events.
 */
public class BookmarkView extends JPanel implements PropertyChangeListener, PetActionView {

    /** The name of this view */
    public final String viewName = "bookmark";

    /** The view models used by this view. */
    private final LoggedInViewModel loggedInViewModel;
    private final BookmarkViewModel bookmarkViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final NotifViewModel notifViewModel;

    /** Controllers for handling various actions. */
    private final PetBioController petBioController;
    private final AdoptController adoptController;
    private final AddBookmarkController addBookmarkController;
    private final RemoveBookmarkController removeBookmarkController;

    /** UI components and layout. */
    JPanel pageBody = new JPanel();
    final JButton notifs = new JButton();
    final JButton myPreferences = new JButton();
    final JButton logout = new JButton();
    final JButton home = new JButton();
    GroupLayout layout = new GroupLayout(this);

    /** Colors and fonts used in the UI. */
    final Color SIDE_BUTTON_COLOR = new Color(255, 189, 65);
    final Color HEADER_COLOR = new Color(255,242,206);
    final Color BACKGROUND_COLOR = new Color (249,249,249);
    final Font SIDE_BUTTON_FONT = new Font("Microsoft JhengHei UI", Font.BOLD, 12);

    /**
     * Constructs a {@code BookmarkView} with the specified view models and controllers.
     *
     * @param bookmarkViewModel the view model for bookmarks
     * @param loggedInViewModel the view model for logged-in user
     * @param preferenceViewModel the view model for user preferences
     * @param loginViewModel the view model for login
     * @param viewManagerModel the view manager model
     * @param notifViewModel the view model for notifications
     * @param petBioController the controller for pet biographies
     * @param adoptController the controller for pet adoption
     * @param removeBookmarkController the controller for removing bookmarks
     * @param addBookmarkController the controller for adding bookmarks
     */
    @SuppressWarnings("unchecked")
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

        bookmarkViewModel.addPropertyChangeListener(this);

        setBackground(HEADER_COLOR);

        notifsButtonDesign();
        notifs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                notifsActionPerformed(evt);
            }
        });

        preferenceButtonDesign();
        myPreferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myPreferencesActionPerformed(evt);
            }
        });

        logoutButtonDesign();
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        homeButtonDesign();
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        pageBody.setBackground(BACKGROUND_COLOR);
        pageBody.setAutoscrolls(true);
        pageBody.setLayout(new GridLayout(5, 4));

        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pageBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(home, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 604, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(myPreferences, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(notifs, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(logout, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addContainerGap()));

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {notifs, myPreferences, logout});

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(notifs, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(myPreferences, GroupLayout.PREFERRED_SIZE, 45,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(logout)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageBody, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                        .addContainerGap())
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {notifs, myPreferences, logout});
    }

    /**
     * Configures the design of the notifications button.
     */
    private void notifsButtonDesign(){
        notifs.setBackground(SIDE_BUTTON_COLOR);
        notifs.setFont(SIDE_BUTTON_FONT); // NOI18N
        notifs.setText(bookmarkViewModel.NOTIF_BUTTON_LABEL);
        notifs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
     * Handles the action performed when the notifications button is clicked.
     *
     * @param evt the action event
     */
    private void notifsActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(notifViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        bookmarkViewModel.removePropertyChangeListener(this);
    }

    /**
     * Configures the design of the preferences button.
     */
    private void preferenceButtonDesign(){
        myPreferences.setBackground(SIDE_BUTTON_COLOR);
        myPreferences.setFont(SIDE_BUTTON_FONT); // NOI18N
        myPreferences.setText(bookmarkViewModel.PREF_BUTTON_LABEL);
        myPreferences.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
     * Handles the action performed when the preferences button is clicked.
     *
     * @param evt the action event
     */
    private void myPreferencesActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(preferenceViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        bookmarkViewModel.removePropertyChangeListener(this);
    }

    /**
     * Configures the design of the logout button.
     */
    private void logoutButtonDesign(){
        logout.setBackground(SIDE_BUTTON_COLOR);
        logout.setFont(SIDE_BUTTON_FONT); // NOI18N
        logout.setText(bookmarkViewModel.LOGOUT_BUTTON_LABEL);
        logout.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
     * Handles the action performed when the logout button is clicked.
     *
     * @param evt the action event
     */
    private void logoutActionPerformed(ActionEvent evt) {
        SessionManager.logout();
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        bookmarkViewModel.removePropertyChangeListener(this);
    }

    /**
     * Configures the design of the home button.
     */
    private void homeButtonDesign(){
        home.setBackground(new Color(255, 153, 153));
        home.setFont(new Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        home.setText(bookmarkViewModel.HOME_BUTTON_LABEL);
        home.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    /**
     * Handles the action performed when the home button is clicked.
     *
     * @param evt the action event
     */
    private void homeActionPerformed(ActionEvent evt) {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
//        bookmarkViewModel.removePropertyChangeListener(this);
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
            List<BookmarkDTO> bookmarks = bookmarkState.getAllBookmarks();
            pageBody.removeAll();
            for (BookmarkDTO bookmark: bookmarks) {
                pageBody.add(new PetListingPanel(this, bookmark.getPet(), false));
            }
            pageBody.revalidate();
            pageBody.repaint();
        }
        else if ("Notification".equals(evt.getPropertyName())) {
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
