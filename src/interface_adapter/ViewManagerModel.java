package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The ViewManagerModel class manages the active view in the application and
 * supports property change notifications to listeners.
 *
 * @version 1.0
 * @since 2024-08-08
 */
public class ViewManagerModel {

    /**
     * The name of the currently active view.
     */
    private String activeViewName;

    /**
     * The support for managing property change listeners and firing property change events.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Gets the name of the currently active view.
     *
     * @return The name of the active view.
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the name of the active view.
     *
     * @param activeView
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Fires a property change event to notify listeners that the active view has changed.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Adds a property change listener to listen for changes in the active view.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
