package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bookmark extends JPanel {

    JPanel pageBody = new JPanel();
    JButton notifs = new JButton();
    JButton myPreferences = new JButton();
    JButton logout = new JButton();
    JButton home = new JButton();

    GroupLayout layout = new GroupLayout(this);

    final Color SIDE_BUTTON_COLOR = new Color(255, 189, 65);
    final Color HEADER_COLOR = new Color(255,242,206);
    final Color BACKGROUND_COLOR = new Color (249,249,249);
    final Font SIDE_BUTTON_FONT = new Font("Microsoft JhengHei UI", Font.BOLD, 12);
    
    public Bookmark() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")     
    private void initComponents() {
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
        notifs.setText("My Profile");
        notifs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void preferenceButtonDesign(){
        myPreferences.setBackground(SIDE_BUTTON_COLOR);
        myPreferences.setFont(SIDE_BUTTON_FONT); // NOI18N
        myPreferences.setText("My Preferences");
        myPreferences.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void logoutButtonDesign(){
        logout.setBackground(SIDE_BUTTON_COLOR);
        logout.setFont(SIDE_BUTTON_FONT); // NOI18N
        logout.setText("Log Out");
        logout.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    private void homeButtonDesign(){
        home.setBackground(new Color(255, 153, 153));
        home.setFont(new Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        home.setText("Home Page");
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
