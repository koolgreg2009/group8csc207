package view;

import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifView {
    private final ViewManager viewManager;
    private final LoggedInViewModel LoggedInViewModel;
    private DefaultListModel<String> notifList;

    public NotifView(LoggedInViewModel loggedInViewModel, ViewManager viewManager) {
        this.LoggedInViewModel = loggedInViewModel;
        this.viewManager = viewManager;

        JLabel title = new JLabel(loggedInViewModel.NOTIF_BUTTON);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addButton = new JButton("You have a new notification!");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNotification("UWU!");
            }
            private void addNotification(String message) {notifList.addElement(message);
            }
        });
        
    }

}
