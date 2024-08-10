package view;

import interface_adapter.PreferenceState;
import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferenceViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Arrays;


/**
 * The PreferenceView class represents the preference screen where users can input and save their preferences.
 * It extends {@code JPanel} and implements {@code ActionListener} and {@code PropertyChangeListener}.
 */
public class PreferenceView extends JPanel implements ActionListener, PropertyChangeListener {

    /**
     * The name of this view
     */
    public final String viewName = "preference";
    private final PreferenceViewModel preferenceViewModel;
    private final DisplayPetsController displayPetsController;


    private final JComboBox<String> speciesComboBox;
    private final JComboBox<String> activityLevelComboBox;
    private final JComboBox<String> genderComboBox;

    final JTextField breedInputField = new JTextField(30);
    private final JLabel breedErrorField = new JLabel();

    final JTextField minAgeInputField = new JTextField(8);
    private final JLabel minAgeErrorField = new JLabel();

    final JTextField maxAgeInputField = new JTextField(8);
    private final JLabel maxAgeErrorField = new JLabel();

    final JTextField locationInputField = new JTextField(15);
    private final JLabel locationErrorField = new JLabel();

    private final JButton save;
    private final JButton clear;
    private final PreferenceController preferenceController;


    /**
     * Constructs a PreferenceView object.
     *
     * @param preferenceViewModel The PreferenceViewModel associated with this view.
     * @param controller The PreferenceController for handling user actions.
     * @param viewManagerModel The ViewManagerModel for managing views.
     * @param displayPetsController The displayPetsController to refresh pets.
     */
    public PreferenceView(PreferenceViewModel preferenceViewModel, PreferenceController controller,
                          ViewManagerModel viewManagerModel, DisplayPetsController displayPetsController) {

        this.preferenceController = controller;
        this.preferenceViewModel = preferenceViewModel;
        this.preferenceViewModel.addPropertyChangeListener(this);
        this.displayPetsController = displayPetsController;

        JLabel title = new JLabel("Preference Screen: If no preference leave blank");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        speciesComboBox = new JComboBox<>(preferenceViewModel.getSpeciesOptions().toArray(new String[0]));
        activityLevelComboBox = new JComboBox<>(preferenceViewModel.getActivityLevelOptions().toArray(new String[0]));
        genderComboBox = new JComboBox<>(preferenceViewModel.getGenderOptions().toArray(new String[0]));

        LabelTextPanel speciesInfo = new LabelTextPanel(new JLabel("Species:"), speciesComboBox);
        LabelTextPanel breedsInfo = new LabelTextPanel(
                new JLabel("Breeds: separate each breed with a comma and a single space"), breedInputField);
        LabelTextPanel minAgeInfo = new LabelTextPanel(
                new JLabel("Minimum Age: enter number"), minAgeInputField);
        LabelTextPanel maxAgeInfo = new LabelTextPanel(
                new JLabel("Maximum Age: enter number"), maxAgeInputField);
        LabelTextPanel activityLevelInfo = new LabelTextPanel(new JLabel("Activity Level:"), activityLevelComboBox);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), locationInputField);
        LabelTextPanel genderInfo = new LabelTextPanel(new JLabel("Gender:"), genderComboBox);


        JPanel buttons = new JPanel();
        save = new JButton(preferenceViewModel.SAVE_BUTTON_LABEL);
        clear = new JButton(preferenceViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);
        buttons.add(save);

        save.addActionListener(
                evt -> {
                    String selectedSpecies = (String) speciesComboBox.getSelectedItem();
                    String selectedActivityLevel = (String) activityLevelComboBox.getSelectedItem();
                    String selectedGender = (String) genderComboBox.getSelectedItem();
                    PreferenceState preferenceState = preferenceViewModel.getState();
                    preferenceState.setSpecies(selectedSpecies);
                    preferenceState.setBreed(breedInputField.getText());
                    preferenceState.setMinAge(minAgeInputField.getText());
                    preferenceState.setMaxAge(maxAgeInputField.getText());
                    preferenceState.setActivityLevel(selectedActivityLevel);
                    preferenceState.setLocation(locationInputField.getText());
                    preferenceState.setGender(selectedGender);
                    List<String> a = preferenceViewModel.capitalizeFirstLetter((preferenceState.getBreed()).split(", "));

                    if (preferenceViewModel.validatePreferences()){
                        preferenceController.execute(
                        preferenceState.getSpecies(),
                                preferenceViewModel.capitalizeFirstLetter((preferenceState.getBreed()).split(", ")),
                                Integer.parseInt(preferenceState.getMinAge()),
                                Integer.parseInt(preferenceState.getMaxAge()),
                                preferenceState.getActivityLevel(),
                                preferenceViewModel.capitalizeFirstLetter(locationInputField.getText()),
                                preferenceState.getGender());

                        displayPetsController.execute(SessionManager.getCurrentUser());
                    } else{
                        updateErrorView();
                    }

                }
        );
        clear.addActionListener(
                evt -> {
                    speciesComboBox.setSelectedItem("");
                    breedInputField.setText("");
                    minAgeInputField.setText("");
                    maxAgeInputField.setText("");
                    locationInputField.setText("");
                    genderComboBox.setSelectedItem("");
                    activityLevelComboBox.setSelectedItem("");
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        breedInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setBreed(breedInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        minAgeInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setMinAge(minAgeInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        maxAgeInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setMaxAge(maxAgeInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

//        activityLevelInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        PreferenceState currentState = preferenceViewModel.getState();
//                        currentState.setActivityLevel(activityLevelInputField.getText() + e.getKeyChar());
//                        preferenceViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });

        locationInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setLocation(locationInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

//        genderInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        PreferenceState currentState = preferenceViewModel.getState();
//                        currentState.setGender(genderInputField.getText() + e.getKeyChar());
//                        preferenceViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });

        this.add(title);
        this.add(speciesInfo);
//        this.add(speciesErrorField);
        this.add(breedErrorField);
        this.add(breedsInfo);
        this.add(minAgeErrorField);
        this.add(minAgeInfo);
        this.add(maxAgeErrorField);
        this.add(maxAgeInfo);
        this.add(activityLevelInfo);
//        this.add(activityLevelErrorField);
        this.add(locationErrorField);
        this.add(locationInfo);
        this.add(genderInfo);
//        this.add(genderErrorField);
        this.add(buttons);
    }

    @Override
        public void actionPerformed(ActionEvent evt) {
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            }
    private void updateErrorView() {
        PreferenceState state = preferenceViewModel.getState();
        minAgeErrorField.setText(state.getMinAgeError());
        maxAgeErrorField.setText(state.getMaxAgeError());
        breedErrorField.setText(state.getBreedError());
        locationErrorField.setText(state.getLocationError());
    }

}


