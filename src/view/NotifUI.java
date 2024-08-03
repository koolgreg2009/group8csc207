package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifUI {
    private DefaultListModel<String> notifList;

    public void notifGUI(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Notification", true);
        dialog.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        notifList = new DefaultListModel<>();
        JList<String> notificationList = new JList<>(notifList);
        notificationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notificationList.setLayoutOrientation(JList.VERTICAL);
        notificationList.setVisibleRowCount(-1);

        JScrollPane listScrollPane = new JScrollPane(notificationList);
        panel.add(listScrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("You have a new notification!");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNotification("UWU!");
            }
        });
        panel.add(addButton, BorderLayout.SOUTH);

        dialog.getContentPane().add(panel);

        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }

    private void addNotification(String message) {
        notifList.addElement(message);
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Main Frame");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new FlowLayout());

        JButton showNotifButton = new JButton("Show Notifications");
        showNotifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NotifUI().notifGUI(mainFrame);
            }
        });

        mainFrame.add(showNotifButton);

        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }
}