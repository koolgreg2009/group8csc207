package interface_adapter.preference;

import interface_adapter.PreferenceState;
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
    public final String BREED_KEY = "breeds";
    private static final int DELAY_MS = 1000;
    /** The current state of the login view. */
    private PreferenceState state = new PreferenceState();

    private final List<String> speciesOptions = Arrays.asList("","Cat");
    private final List<String> activityLevelOptions = Arrays.asList("","Not Active", "Slightly Active", "Moderately Active", "Highly Active");
    private final List<String> genderOptions = Arrays.asList("","Male", "Female");
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
    public void firePropertyChanged() {
        support.firePropertyChange("clear", null, this.state);
    }

    public void fireMatchPropertyChanged() {
        support.firePropertyChange("matches", null, this.state);
    }
    public void fireTimePropertyChanged() {
        support.firePropertyChange("time", null, this.state);
    }
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
    public boolean validatePreferences() {
        boolean isValid = true;
//
//
//        if (!validateBreed()) {
//            isValid = false;
//        }

        if (!validateMinAge()) {
            isValid = false;
        }

        if (!validateMaxAge()) {
            isValid = false;
        }

//        if (!validateLocation()) {
//            isValid = false;
//        }

        firePropertyChanged();
        return isValid;
    }


//    private boolean validateBreed() {
//        if (state.getBreed().isEmpty()) {
//            state.setBreedError("Breed cannot be empty");
//            return false;
//        } else {
//            state.setBreedError("");
//            return true;
//        }
//    }

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
     * @param input
     * @return
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
     * Timer to track fixed time interval of DELAY_MS between user input
     */
    public void createDelay(){
        Timer timer = new Timer(DELAY_MS, e -> fireTimePropertyChanged());
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Timer to track time interval between each user interaction
     */
    public void userInteracted(){
        state.setInteraction(true);
        Timer timer = new Timer(DELAY_MS, e -> state.setInteraction(false));
        timer.setRepeats(false);
        timer.start();
    }

}

