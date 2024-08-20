package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The ViewManager class is responsible for managing and displaying different views in the application.
 * It listens for changes in the view model and updates the displayed view accordingly using a CardLayout.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new ViewManager with the specified views panel, CardLayout, and view manager model.
     *
     * @param views The {@code JPanel} that contains all the views to be managed.
     * @param cardLayout The {@code CardLayout} used for switching between views.
     * @param viewManagerModel The {@code ViewManagerModel} that provides view change notifications.
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    /**
     * Listens for property changes in the view manager model.
     * If the "view" property changes, updates the displayed view using CardLayout.
     *
     * @param evt The {@code PropertyChangeEvent} containing details of the change.
     *             This event provides the property name and the new value associated with the change.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
