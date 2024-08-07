package view;

import interface_adapter.ProfileViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.bookmark.RemoveBookmarkController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.preference.PreferenceViewModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookmarkView extends JPanel {

    private final LoggedInViewModel loggedInViewModel;
    private final BookmarkViewModel bookmarkViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final LoginViewModel loginViewModel;
    private final ProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;
    private final AddBookmarkController addBookmarkController;
    private final RemoveBookmarkController removeBookmarkController;

    JPanel pageBody = new JPanel();
    final JButton notifs = new JButton();
    final JButton myPreferences = new JButton();
    final JButton logout = new JButton();
    final JButton home = new JButton();

    GroupLayout layout = new GroupLayout(this);

    final Color SIDE_BUTTON_COLOR = new Color(255, 189, 65);
    final Color HEADER_COLOR = new Color(255,242,206);
    final Color BACKGROUND_COLOR = new Color (249,249,249);
    final Font SIDE_BUTTON_FONT = new Font("Microsoft JhengHei UI", Font.BOLD, 12);

    @SuppressWarnings("unchecked")     
    private BookmarkView (LoggedInViewModel loggedInViewModel,
                          BookmarkViewModel bookmarkViewModel,
                          PreferenceViewModel preferenceViewModel,
                          LoginViewModel loginViewModel,
                          ProfileViewModel profileViewModel,
                          ViewManagerModel viewManagerModel,
                          RemoveBookmarkController removeBookmarkController,
                          AddBookmarkController addBookmarkController) {

        this.loggedInViewModel = loggedInViewModel;
        this.bookmarkViewModel = bookmarkViewModel;
        this.preferenceViewModel = preferenceViewModel;
        this.loginViewModel = loginViewModel;
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.removeBookmarkController = removeBookmarkController;
        this.addBookmarkController = addBookmarkController;

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
        layout.setHorizontalGroup(horizontalGroup());
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {notifs, myPreferences, logout});
        layout.setVerticalGroup(verticalGroup());
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {notifs, myPreferences, logout});
    }
    
    private void notifsButtonDesign(){
        notifs.setBackground(SIDE_BUTTON_COLOR);
        notifs.setFont(SIDE_BUTTON_FONT); // NOI18N
        notifs.setText(bookmarkViewModel.NOTIF_BUTTON_LABEL);
        notifs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void preferenceButtonDesign(){
        myPreferences.setBackground(SIDE_BUTTON_COLOR);
        myPreferences.setFont(SIDE_BUTTON_FONT); // NOI18N
        myPreferences.setText(bookmarkViewModel.PREF_BUTTON_LABEL);
        myPreferences.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void logoutButtonDesign(){
        logout.setBackground(SIDE_BUTTON_COLOR);
        logout.setFont(SIDE_BUTTON_FONT); // NOI18N
        logout.setText(bookmarkViewModel.LOGOUT_BUTTON_LABEL);
        logout.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void homeButtonDesign(){
        home.setBackground(new Color(255, 153, 153));
        home.setFont(new Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        home.setText(bookmarkViewModel.HOME_BUTTON_LABEL);
        home.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    private GroupLayout.Group horizontalGroup(){
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pageBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 604, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(notifs, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(myPreferences, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(logout, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addContainerGap());
    }

    private GroupLayout.Group verticalGroup(){
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(notifs, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(myPreferences)
                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(logout)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageBody, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap());
    }

    private void notifsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // Basically want to display a popup of notifications
    }

    private void myPreferencesActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // Display Preferences Page
    }

    private void logoutActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // Display Logout page
    }

    private void homeActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // Go back to Home page
    }

}
