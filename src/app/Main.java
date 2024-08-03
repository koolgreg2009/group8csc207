package view.bookmark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookmarkHeader extends JPanel implements ActionListener {

    public final Color BACKGROUND_COLOR = new Color(250,248,228);
    public final Font SIDE_BUTTONS_FONT = new Font("Microsoft JhengHei UI", Font.BOLD, 12);
    public final Color SIDE_BUTTONS_COLOR = new Color(255,189,65);

    JButton myProfileButton = new JButton();
    JButton myPreferencesButton = new JButton();
    JButton logoutButton = new JButton();
    JButton homeButton = new JButton();
    GroupLayout layout = new GroupLayout(this);

    public BookmarkHeader() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setBackground(BACKGROUND_COLOR);

        profileButtonDesign();
        myProfileButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                myProfileButtonActionPerformed(event);
            }
        });

        preferenceButtonDesign();
        myPreferencesButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                myPreferencesButtonActionPerformed(event);
            }
        });

        logoutButtonDesign();
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                logoutButtonActionPerformed(event);
            }
        });

        homeButtonDesign();
        homeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                homeButtonActionPerformed(event);
            }
        });

        buttonLayout();
    }

    private void homeButtonDesign(){
        homeButton.setBackground(new Color(255,153,153));
        homeButton.setText("Home Page");
        homeButton.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
        homeButton.setBorder(BorderFactory.createBevelBorder(0));
    }

    private void profileButtonDesign(){
        myProfileButton.setBackground(SIDE_BUTTONS_COLOR);
        myProfileButton.setText("My Profile");
        myProfileButton.setFont(SIDE_BUTTONS_FONT);
        myProfileButton.setBorder(BorderFactory.createBevelBorder(0));
    }

    private void logoutButtonDesign(){
        logoutButton.setBackground(SIDE_BUTTONS_COLOR);
        logoutButton.setText("Log Out");
        logoutButton.setFont(SIDE_BUTTONS_FONT);
        logoutButton.setBorder(BorderFactory.createBevelBorder(0));
    }

    private void preferenceButtonDesign(){
        myPreferencesButton.setBackground(SIDE_BUTTONS_COLOR);
        myPreferencesButton.setText("My Preferences");
        myPreferencesButton.setFont(SIDE_BUTTONS_FONT);
        myPreferencesButton.setBorder(BorderFactory.createBevelBorder(0));
    }

    private void buttonLayout(){
        this.setLayout(layout);
        layout.setHorizontalGroup(horizontalGroup());
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {myProfileButton, myPreferencesButton, logoutButton});
        layout.setVerticalGroup(verticalGroup());
    }

    private GroupLayout.SequentialGroup logoutHGroup(){
        return layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE);
    }

    private GroupLayout.SequentialGroup homeAndPreferenceHGroup() {
        return layout.createSequentialGroup().addContainerGap()
                .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addComponent(myPreferencesButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE);
    }

    private GroupLayout.SequentialGroup profileHGroup(){
        return layout.createSequentialGroup()
                .addGap(716, 716, 716)
                .addComponent(myProfileButton, GroupLayout.PREFERRED_SIZE, 123,
                        GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE);
    }

    private GroupLayout.Group horizontalGroup(){
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(logoutHGroup())
                                .addGroup(profileHGroup())
                                .addGroup(GroupLayout.Alignment.TRAILING, homeAndPreferenceHGroup()))
                        .addContainerGap());
    }

    private GroupLayout.ParallelGroup homeAndPreferenceVGroup(){
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(5,5,5)
                        .addComponent(myPreferencesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGap(2,2,2)
                        .addComponent(homeButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE));

    }

    private GroupLayout.Group verticalGroup(){
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(myProfileButton, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGroup(homeAndPreferenceVGroup())
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addContainerGap());
    }

    private void
}
