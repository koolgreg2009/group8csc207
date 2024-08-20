package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The ProfileView class represents the profile screen for the user.
 * It extends {@code JPanel} and implements {@code ActionListener} and {@code PropertyChangeListener}.
 */
public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";

    /**
     * Handles action events for components within this view.
     *
     * @param e An {@code ActionEvent} object describing the action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Handles property change events and updates the view accordingly.
     *
     * @param evt A {@code PropertyChangeEvent} object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
