package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import dto.PetDTO;
import interface_adapter.ProfileViewModel;
import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
import interface_adapter.adopt.NotifViewModel;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.bookmark.RemoveBookmarkController;
//import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.preference.PreferenceViewModel;

//We need to work on this. -Justin

public class LoggedInView extends JPanel implements PetActionView, ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final BookmarkViewModel bookmarkViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final ProfileViewModel profileViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final NotifViewModel notifViewModel;


    JLabel username;

    private final JButton logOut;
    private final JButton preferences;
    private final JButton bookmark;
    private final JButton notifications;
    private final JPanel petListingPanel;
	private final PetBioController petBioController;
    //private final DisplayAllPetsController displayAllPetsController;
    private final AdoptController adoptController;
    private final AddBookmarkController addBookmarkController;
    private final RemoveBookmarkController removeBookmarkController;

    /**
     * A window with a title and a JButton.
     */
	public LoggedInView(PetBioController petBioController,
                        LoggedInViewModel loggedInViewModel,
                        BookmarkViewModel bookmarkViewModel,
                        PreferenceViewModel preferenceViewModel,
                        LoginViewModel loginViewModel,
                        ProfileViewModel profileViewModel,
                        NotifViewModel notifViewModel,
                        ViewManagerModel viewManagerModel,
                        AdoptController adoptController,
                        AddBookmarkController addBookmarkController,
                        RemoveBookmarkController removeBookmarkController) {
		this.petBioController = petBioController;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.bookmarkViewModel = bookmarkViewModel;
        this.preferenceViewModel = preferenceViewModel;
        this.profileViewModel = profileViewModel;
        this.notifViewModel = notifViewModel;
        this.loginViewModel = loginViewModel;
        this.adoptController = adoptController;
        this.addBookmarkController = addBookmarkController;
        this.removeBookmarkController = removeBookmarkController;
        this.loggedInViewModel.addPropertyChangeListener(this);
        this.viewManagerModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Home Page Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel usernameInfo = new JLabel("Currently logged in: " + loggedInViewModel.getLoggedInUser());
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();

        JPanel buttons = new JPanel();
        notifications = new JButton(loggedInViewModel.NOTIF_BUTTON);
        buttons.add(notifications);
        preferences = new JButton(loggedInViewModel.PREFERENCE_BUTTON_LABEL);
        buttons.add(preferences);
        bookmark = new JButton(loggedInViewModel.BOOKMARK_BUTTON_LABEL);
        buttons.add(bookmark);
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);
        petListingPanel = new JPanel();
        petListingPanel.setLayout(new GridLayout(0, 3));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
        JScrollPane petScrollPanel = new JScrollPane(petListingPanel);
        this.add(petScrollPanel);
        notifications.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(notifViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        preferences.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(preferenceViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        bookmark.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(bookmarkViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        logOut.addActionListener(
                evt -> {
                    SessionManager.logout();
                    viewManagerModel.setActiveView(loginViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
    }

    /**
     * React to a button click that results in evt.
     */
    @Override
	public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    private void showNotification() {
        LoggedInState state = loggedInViewModel.getState();
        if (state.isNotificationSuccess()) {
            JOptionPane.showMessageDialog(this, state.getNotificationMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, state.getNotificationMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
            List<PetDTO> pets = state.getPets();
            petListingPanel.removeAll();
            for (PetDTO pet : pets) {
                petListingPanel.add(new PetListingPanel(this, pet, true));
            }
            petListingPanel.revalidate();
            petListingPanel.repaint();
//        } else if (evt.getPropertyName().equals("view") && evt.getNewValue().equals("logged in")){
//            displayAllPetsController.execute();
        }
        else if ("notification".equals(evt.getPropertyName())) {
            showNotification();
        }

        
        // add method here
    }


	@Override
	public void add(int petID) {
        addBookmarkController.execute(petID);
	}
    @Override
    public void remove(int petID){
        removeBookmarkController.execute(petID);
    }

	@Override
	public void goDetail(int petID) {
		petBioController.execute(username.getText(), petID);
	}

	@Override
	public void adopt(int petID) {
		adoptController.execute(petID);
		
	}
}
