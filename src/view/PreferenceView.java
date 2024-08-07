package view;

import interface_adapter.PreferenceState;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferenceViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PreferenceView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "preference";
    private final PreferenceViewModel preferenceViewModel;
    private final ViewManagerModel viewManagerModel;


    final JTextField speciesInputField = new JTextField(15);
    private final JLabel speciesErrorField = new JLabel();

    final JTextField breedInputField = new JTextField(30);
    private final JLabel breedErrorField = new JLabel();

    final JTextField minAgeInputField = new JTextField(8);
    private final JLabel minAgeErrorField = new JLabel();

    final JTextField maxAgeInputField = new JTextField(8);
    private final JLabel maxAgeErrorField = new JLabel();

    final JTextField activityLevelInputField = new JTextField(15);
    private final JLabel activityLevelErrorField = new JLabel();

    final JTextField locationInputField = new JTextField(15);
    private final JLabel locationErrorField = new JLabel();

    final JTextField genderInputField = new JTextField(8);
    private final JLabel genderErrorField = new JLabel();

    final JButton save;
    private final PreferenceController preferenceController;

    public PreferenceView(PreferenceViewModel preferenceViewModel, PreferenceController controller,
                          ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {

        this.preferenceController = controller;
        this.preferenceViewModel = preferenceViewModel;
        this.preferenceViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel("Preference Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel speciesInfo = new LabelTextPanel(
                new JLabel("Species, type only one"), speciesInputField);
        LabelTextPanel breedsInfo = new LabelTextPanel(
                new JLabel("Breeds, seperate each breed with a comma and a single space"), breedInputField);
        LabelTextPanel minAgeInfo = new LabelTextPanel(
                new JLabel("Minimum Age, enter a whole number"), minAgeInputField);
        LabelTextPanel maxAgeInfo = new LabelTextPanel(
                new JLabel("Maximum Age, enter a whole number"), maxAgeInputField);
        LabelTextPanel activityLevelInfo = new LabelTextPanel(
                new JLabel("Activity Level, low, medium, or high"), activityLevelInputField);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), locationInputField);
        LabelTextPanel genderInfo = new LabelTextPanel(
                new JLabel("Select Gender, Enter M or F"), genderInputField);



        JPanel buttons = new JPanel();
        save = new JButton(preferenceViewModel.SAVE_BUTTON_LABEL);
        buttons.add(save);



        save.addActionListener(
                evt -> {
                    int minAgeNum;

                    if (minAgeInputField.getText() == null || minAgeInputField.getText().isEmpty()) {
                        minAgeNum = 0; // Set to 0 if the string is null or empty
                    } else {
                        try {
                            minAgeNum = Integer.parseInt(minAgeInputField.getText()); // Convert the string to an integer
                        } catch (NumberFormatException e) {
                            minAgeNum = 0; // Set to 0 if the string cannot be parsed as an integer
                        }
                    }
                    int maxAgeNum;

                    if (maxAgeInputField.getText() == null || maxAgeInputField.getText().isEmpty()) {
                        maxAgeNum = 100; // Set to 100 if the string is null or empty
                    } else {
                        try {
                            maxAgeNum = Integer.parseInt(maxAgeInputField.getText()); // Convert the string to an integer
                        } catch (NumberFormatException e) {
                            maxAgeNum = 100; // Set to 100 if the string cannot be parsed as an integer
                        }
                    }

                    String breeds = breedInputField.getText();
                    ArrayList<String> breedsList;

                    if (breeds == null || breeds.isEmpty()) {
                        // If the string is empty, set wordsList to an empty ArrayList
                        breedsList = new ArrayList<>();
                    } else {
                        // Split the string by the delimiter ", " and convert to an ArrayList
                        String[] wordsArray = breeds.split(", ");
                        breedsList = new ArrayList<>(Arrays.asList(wordsArray));
                    }
                    preferenceController.execute(speciesInputField.getText(), breedsList, minAgeNum, maxAgeNum, activityLevelInputField.getText(), locationInputField.getText(), genderInputField.getText());
                    viewManagerModel.setActiveView(loggedInViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                    // to do: add displayallpet usecase
                }
        );

        speciesInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                PreferenceState currentState = preferenceViewModel.getState();
                currentState.setSpecies(speciesInputField.getText() + e.getKeyChar());
                preferenceViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
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

        activityLevelInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setActivityLevel(activityLevelInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

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

        genderInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        PreferenceState currentState = preferenceViewModel.getState();
                        currentState.setGender(genderInputField.getText() + e.getKeyChar());
                        preferenceViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.add(title);
        this.add(speciesInfo);
        this.add(speciesErrorField);
        this.add(breedsInfo);
        this.add(breedErrorField);
        this.add(minAgeInfo);
        this.add(minAgeErrorField);
        this.add(maxAgeInfo);
        this.add(maxAgeErrorField);
        this.add(activityLevelInfo);
        this.add(activityLevelErrorField);
        this.add(locationInfo);
        this.add(locationErrorField);
        this.add(genderInfo);
        this.add(genderErrorField);
        this.add(buttons);
    }

    //species, breeds, minAge, maxAge, activityLevel, location, gender
    @Override
    public void actionPerformed(ActionEvent evt) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        }

    }

