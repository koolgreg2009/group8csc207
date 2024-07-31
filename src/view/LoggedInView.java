package view;

import interface_adapter.ProfileViewModel;
import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.preference.PreferenceViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//We need to work on this. -Justin

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final BookmarkViewModel bookmarkViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final ProfileViewModel profileViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;


    JLabel username;

    private final JButton logOut;
    private final JButton preferences;
    private final JButton bookmark;
    private final JButton profile;


    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        BookmarkViewModel bookmarkViewModel,
                        PreferenceViewModel preferenceViewModel,
                        LoginViewModel loginViewModel,
                        ProfileViewModel profileViewModel,

                        ViewManagerModel viewManagerModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.bookmarkViewModel = bookmarkViewModel;
        this.preferenceViewModel = preferenceViewModel;
        this.profileViewModel = profileViewModel;
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Home Page Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        profile = new JButton(loggedInViewModel.PROFILE_BUTTON_LABEL);
        buttons.add(profile);
        preferences = new JButton(loggedInViewModel.PREFERENCE_BUTTON_LABEL);
        buttons.add(preferences);
        bookmark = new JButton(loggedInViewModel.BOOKMARK_BUTTON_LABEL);
        buttons.add(bookmark);
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        logOut.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
        profile.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(profileViewModel.getViewName());
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
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}
