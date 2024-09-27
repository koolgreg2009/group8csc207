package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * An abstract base class for view models in the application.
 * <p>
 * This class provides a common interface for view models, including managing the view name and supporting
 * property change notifications. Concrete subclasses must implement the methods for notifying property changes
 * and adding property change listeners.
 */
public abstract class ViewModel {
    private String viewName;

    /**
     * Constructs a ViewModel with the specified view name.
     *
     * @param viewName the name of the view this ViewModel is associated with
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Gets the name of the view associated with this view model.
     *
     * @return the name of the view
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Notifies listeners that a property change has occurred.
     * <p>
     * Subclasses must implement this method to specify how property changes are fired.
     */
    public abstract void firePropertyChanged();

    /**
     * Adds a property change listener to be notified of property changes.
     * <p>
     * Subclasses must implement this method to handle adding listeners.
     *
     * @param listener the property change listener to add
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
