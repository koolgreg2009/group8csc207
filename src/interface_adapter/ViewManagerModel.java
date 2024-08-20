package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Manages the currently active view in the application and supports property change notifications.
 * <p>
 * This class is responsible for keeping track of which view is currently active and notifying listeners
 * when the active view changes. It utilizes property change support to handle changes and listener notifications.
 */
public class ViewManagerModel {

    /**
     * The name of the currently active view.
     */
    private String activeViewName;

     /**
     * Manages property change listeners and firing property change events.
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
     * @param activeView the name of the view to set as active
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Notifies all registered listeners that the active view has changed.
     * This method fires a property change event with the property name "view".
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Adds a property change listener to be notified of changes to the active view.
     *
     * @param listener the property change listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
