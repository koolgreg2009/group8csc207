package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.NotifViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NotifView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final NotifViewModel notifViewModel;
    public String viewName = "notification";
    private DefaultListModel<String> notifList;

    public NotifView(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel, NotifViewModel notifViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.notifViewModel = notifViewModel;
        this.notifViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(loggedInViewModel.NOTIF_BUTTON);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BorderLayout());

        notifList = new DefaultListModel<>();
        JList<String> notificationList = new JList<>(notifList);
        notificationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notificationList.setLayoutOrientation(JList.VERTICAL);
        notificationList.setVisibleRowCount(-1);

        JScrollPane listScrollPane = new JScrollPane(notificationList);
        this.add(listScrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("You have a new notification!");
        addButton.addActionListener(this); // Attach the action listener to the button
        this.add(addButton, BorderLayout.SOUTH);
    }

    private void addNotification(String message) {
        notifList.addElement(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("You have a new notification!".equals(command)) {
            addNotification("Pet has been adopted");
            JButton back = new JButton(notifViewModel.BACK_BUTTON_LABEL);
            this.add(back, BorderLayout.WEST);
            back.addActionListener(
                    evt -> {
                        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
                        viewManagerModel.firePropertyChanged();
                    }
            );
            remove((Component) e.getSource()); // Remove the button from the panel after user has seen the notification
            revalidate();
            repaint(); // Repaint the panel to ensure the changes are visible
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("newNotification".equals(evt.getPropertyName())) {
            String newNotification = (String) evt.getNewValue();
            addNotification(newNotification);
        }
    }
}