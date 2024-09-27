package view;

import java.util.List;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.NotificationState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code NotifView} class represents the user interface for displaying notifications.
 * <p>
 * It includes a list of notifications and a button to return to the previous view.
 */
public class NotifView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final NotifViewModel notifViewModel;
    public String viewName = "notification";
    private DefaultListModel<String> notifList;

    /**
     * Constructs a new {@code NotifView} with the specified view models and view manager.
     *
     * @param loggedInViewModel the view model for the logged-in user.
     * @param viewManagerModel the model for managing views.
     * @param notifViewModel the view model for notifications.
     */
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

        JButton back = new JButton(notifViewModel.BACK_BUTTON_LABEL);
        this.add(back, BorderLayout.WEST);
        back.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(loggedInViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
    }

    /**
     * Adds a list of notifications to the view.
     *
     * @param message a list of notification messages to be displayed.
     */
    private void addNotification(List<String> message) {
        if (notifList != null) {
            for (String msg : message) {
                notifList.addElement(msg);
            }
        }
    }

    /**
     * Handles action events. (Currently not used but included for the ActionListener interface.)
     *
     * @param e the action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        }

    /**
     * Responds to property change events by updating the notifications list.
     *
     * @param evt the property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            NotificationState newNotification = (NotificationState) evt.getNewValue();
            notifList.removeAllElements();
            addNotification(newNotification.getNotif());
        }
    }
}