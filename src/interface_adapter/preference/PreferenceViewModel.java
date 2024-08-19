package interface_adapter.preference;

import interface_adapter.ViewModel;


import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreferenceViewModel extends ViewModel {

    /** The label for the login button. */
    public final String SAVE_BUTTON_LABEL = "Save Preferences";
    public final String CLEAR_BUTTON_LABEL = "Clear Preferences";
    /** Keys for view fields */
    public final String BREED_KEY = "breeds";
    public final String LOCATION_KEY = "locations";

    /** Time delay between popups */
    private static final int DELAY_MS = 1000;
    /** The current state of the login view. */
    private PreferenceState state = new PreferenceState();

    /**
     * Options for pop up menus
     */
    private final List<String> speciesOptions = Arrays.asList("","Cat");
    private final List<String> activityLevelOptions = Arrays.asList("","Not Active", "Slightly Active", "Moderately Active", "Highly Active");
    private final List<String> genderOptions = Arrays.asList("","Male", "Female");
    private Timer delayTimer;
    private Timer interactionTimer;

    public PreferenceViewModel() {
        super("preference");
    }
    /**
     * Sets the state of the preference view model.
     *
     * @param state the state that is being set
     */
    public void setState(PreferenceState state) {
        this.state = state;
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of changes in the
     * login state.
     */
    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, this.state);
    }

    public void fireTimePropertyChanged(String key) {
        support.firePropertyChange(key, null, this.state);
    }

    @Override
    public void firePropertyChanged() {}

    /**
     * Adds a property change listener to be notified of changes in the preference
     * state.
     *
     * @param listener the listener for the preference property changes
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the preference view model.
     *
     * @return The current preference state.
     */
    public PreferenceState getState() {
        return state;
    }
    public void clearState(){
        state = new PreferenceState();
    }

    public List<String> getSpeciesOptions() {
        return speciesOptions;
    }
    public List<String> getActivityLevelOptions() {
        return activityLevelOptions;
    }
    public List<String> getGenderOptions() {
        return genderOptions;
    }

    /**
     * Validates fields that dont require DAO from state like åge
     * @return
     */
    public boolean validatePreferences() {
        boolean isValid = true;
        if (!validateMinAge()) {
            isValid = false;
        }

        if (!validateMaxAge()) {
            isValid = false;
        }

        firePropertyChanged();
        return isValid;
    }

    /**
     * Validate min age. If empty string set minage to 0 which is no preference
     * @return bool whether if pass
     */
    private boolean validateMinAge() {
        if (!state.getMinAge().isEmpty()) {
            try {
                int minAge = Integer.parseInt(state.getMinAge());
                if (minAge < 0) {
                    state.setMinAgeError("Minimum age cannot be negative");
                    return false;
                }
            }catch (NumberFormatException e) {
                state.setMinAgeError("Minimum age must be an integer");
                return false;
            }
        }else{
            state.setMinAgeError("");
            state.setMinAge("0");
        }

        return true;
    }

    /**
     * Validate max age. If empty string set the default value which is 0 which means no pref
     * @return
     */
    private boolean validateMaxAge() {
        if (!state.getMaxAge().isEmpty()) {
            try {
                int maxAge = Integer.parseInt(state.getMaxAge());
                if (maxAge < 0) {
                    state.setMaxAgeError("Maximum age cannot be negative");
                    return false;
                } else if (!state.getMinAge().isEmpty()) {
                    int minAge = Integer.parseInt(state.getMinAge());
                    if (maxAge < minAge) {
                        state.setMaxAgeError("Maximum age cannot be less than minimum age");
                        return false;
                    }
                }
            } catch (NumberFormatException e) {
                state.setMaxAgeError("Maximum age must be an integer");
                return false;
            }
        } else {
            state.setMaxAgeError("");
            state.setMaxAge("0");
        }
        return true;
    }


    /**
     * makes strings properly formatted for dao to work. taking into account of spaces between words like domestic short
     * hair
     * @param input: string
     * @return: capitalized string
     */
    public String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.split(" ");

        StringBuilder capitalizedWords = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalizedWords.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase());
            }
            capitalizedWords.append(" ");
        }
        return capitalizedWords.toString().trim();
    }

    public List<String> capitalizeFirstLetter(String[] input) {
        List<String> newList = new ArrayList<>();
        if (input.length != 1 | !input[0].isEmpty()) {
            for (String word : input) newList.add(!word.isEmpty() ? capitalizeFirstLetter(word.trim()) : word);
        }
        return newList;
    }

    /**
     * Updates component input to state and starts conditions to initiate dropdown menu.
     * @param keyChar: input key entered
     * @param key: key to indicate what field user is interacting with
     */
    public void handleUserInput(char keyChar, String key){
        PreferenceState currentState = getState();
        switch(key){
            case BREED_KEY:
                currentState.setBreed(currentState.getBreed() + keyChar);
                break;
            case LOCATION_KEY:
                currentState.setLocation(currentState.getLocation() + keyChar);
                break;
        }
        setState(currentState);
        createDelay(key);
        userInteracted();
    }

    /**
     * Condition: dropdown only shows after DELAY_MS seconds.
     * If there is already a timer restart timer
     * If after DELAY_MS ifInteraction is true then trigger view observer to execute usecase
     * @param key
     */
    private void createDelay(String key) {
        if (delayTimer != null && delayTimer.isRunning()) {
            delayTimer.stop();
        }
        delayTimer = new Timer(DELAY_MS, e -> {
            if (state.isInteraction()) {
                fireTimePropertyChanged(key);
            }
        });        delayTimer.setRepeats(false);
        delayTimer.start();
    }

    /**
     * Condition: dropdown only shows after DELAY_MS seconds of previous user interaction, setting boolean isInteraction
     * to true after DELAY_MS
     * If there is already a timer restart timer
     */
    private void userInteracted() {
        state.setInteraction(true);

        if (interactionTimer != null && interactionTimer.isRunning()) {
            interactionTimer.stop();
        }

        interactionTimer = new Timer(DELAY_MS, e -> state.setInteraction(false));
        interactionTimer.setRepeats(false);
        interactionTimer.start();
    }


}

