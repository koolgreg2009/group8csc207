package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The ViewManager class is responsible for managing and displaying different views in the application.
 * It listens for changes in the view model and updates the displayed view accordingly using a CardLayout.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new ViewManager with the specified views panel, CardLayout, and view manager model.
     *
     * @param views
     * @param cardLayout
     * @param viewManagerModel
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
     * @param evt The property change event containing details of the change.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
