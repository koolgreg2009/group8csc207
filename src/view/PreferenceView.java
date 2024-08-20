package view;

import interface_adapter.preference.PreferenceState;
import interface_adapter.SessionManager;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.get_matching.GetMatchingController;
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


/**
 * The PreferenceView class represents the preference screen where users can input and save their preferences.
 * It extends {@code JPanel} and implements {@code ActionListener} and {@code PropertyChangeListener}.
 */
public class PreferenceView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "preference";
    private final PreferenceViewModel preferenceViewModel;
    private final DisplayPetsController displayPetsController;
    private final GetMatchingController getMatchingController;

    private final JComboBox<String> speciesComboBox;
    private final JComboBox<String> activityLevelComboBox;
    private final JComboBox<String> genderComboBox;

    final JTextField breedInputField = new JTextField(15);
    private final JLabel breedErrorField = new JLabel();

    final JTextField minAgeInputField = new JTextField(5);
    private final JLabel minAgeErrorField = new JLabel();

    final JTextField maxAgeInputField = new JTextField(5);
    private final JLabel maxAgeErrorField = new JLabel();

    final JTextField locationInputField = new JTextField(15);
    private final JLabel locationErrorField = new JLabel();

    private final JButton save;
    private final JButton clear;
    private final PreferenceController preferenceController;
    private final JPopupMenu breedPopupMenu = new JPopupMenu();
    private final JPopupMenu locationPopupMenu = new JPopupMenu();

    private ComponentPair currentComponent;

    /**
     * Constructs a PreferenceView object with the specified view model, controllers, and preferences.
     *
     * @param preferenceViewModel The {@code PreferenceViewModel} associated with this view.
     * @param controller The {@code PreferenceController} for handling user actions.
     * @param getMatchingController The {@code GetMatchingController} for finding matching strings.
     * @param displayPetsController The {@code DisplayPetsController} to refresh pet displays.
     */
    public PreferenceView(PreferenceViewModel preferenceViewModel, PreferenceController controller,
                          GetMatchingController getMatchingController, DisplayPetsController displayPetsController) {

        this.preferenceController = controller;
        this.preferenceViewModel = preferenceViewModel;
        this.preferenceViewModel.addPropertyChangeListener(this);
        this.displayPetsController = displayPetsController;
        this.getMatchingController = getMatchingController;

        JLabel title = new JLabel("Preference Screen: If no preference leave blank");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        speciesComboBox = new JComboBox<>(preferenceViewModel.getSpeciesOptions().toArray(new String[0]));
        speciesComboBox.setBackground(Color.white);
        activityLevelComboBox = new JComboBox<>(preferenceViewModel.getActivityLevelOptions().toArray(new String[0]));
        activityLevelComboBox.setBackground(Color.white);
        genderComboBox = new JComboBox<>(preferenceViewModel.getGenderOptions().toArray(new String[0]));
        genderComboBox.setBackground(Color.white);
        breedPopupMenu.setInvoker(breedInputField);
        locationPopupMenu.setInvoker(locationInputField);

        LabelTextPanel speciesInfo = new LabelTextPanel(new JLabel("Species:"), speciesComboBox);
        LabelTextPanel breedsInfo = new LabelTextPanel(
                new JLabel("Breed: "), breedInputField);
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
        ComponentPair breedComponents = new ComponentPair(breedInputField, breedPopupMenu);
        ComponentPair locationComponents = new ComponentPair(locationInputField, locationPopupMenu);

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

                    if (preferenceViewModel.validatePreferences()) {
                        preferenceController.execute(
                                preferenceState.getSpecies(),
                                preferenceViewModel.capitalizeFirstLetter((preferenceState.getBreed().trim()).split(", ")),
                                "breeds",
                                Integer.parseInt(preferenceState.getMinAge()),
                                Integer.parseInt(preferenceState.getMaxAge()),
                                preferenceState.getActivityLevel(),
                                preferenceState.getLocation().trim(),
                                "locations",
                                preferenceState.getGender());


                    } else {
                        updateErrorView();
                    }

                }
        );

        clear.addActionListener(
                evt -> {
                    preferenceViewModel.clearState();
                    PreferenceState state = preferenceViewModel.getState();
                    speciesComboBox.setSelectedItem(state.getSpecies());
                    breedInputField.setText(state.getBreed());
                    minAgeInputField.setText(state.getMinAge());
                    maxAgeInputField.setText(state.getMaxAge());
                    locationInputField.setText(state.getLocation());
                    genderComboBox.setSelectedItem(state.getGender());
                    activityLevelComboBox.setSelectedItem(state.getActivityLevel());

                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        speciesComboBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    breedInputField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        breedInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String key = "";
                key = preferenceViewModel.BREED_KEY;
                currentComponent = breedComponents;
                preferenceViewModel.handleUserInput(e.getKeyChar(), key);

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    minAgeInputField.requestFocus();
                }
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
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            maxAgeInputField.requestFocus();
                        }
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
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            activityLevelComboBox.requestFocus();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        activityLevelComboBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    locationInputField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        locationInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object source = e.getSource();
                String key = "";
                key = preferenceViewModel.LOCATION_KEY;
                currentComponent = locationComponents;
                preferenceViewModel.handleUserInput(e.getKeyChar(), key);

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    genderComboBox.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        genderComboBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.add(title);
        this.add(speciesInfo);
        this.add(breedErrorField);
        this.add(breedsInfo);
        this.add(minAgeErrorField);
        this.add(minAgeInfo);
        this.add(maxAgeErrorField);
        this.add(maxAgeInfo);
        this.add(activityLevelInfo);
        this.add(locationErrorField);
        this.add(locationInfo);
        this.add(genderInfo);
        this.add(buttons);
    }

    /**
     * Handles action events for buttons and other interactive components.
     *
     * @param evt An {@code ActionEvent} object describing the action event.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
    }

    /**
     * Handles property change events and updates the view accordingly.
     *
     * @param evt A {@code PropertyChangeEvent} object describing the event source
     *            and the property that has changed. Possible events include:
     *            - "matches": Updates the popup menu with new matching lists.
     *            - preferenceViewModel.BREED_KEY: Updates breed matching.
     *            - preferenceViewModel.LOCATION_KEY: Updates location matching.
     *            - "error": Updates error messages in the view.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            if ("matches".equals(evt.getPropertyName())) {
                updatePopup(currentComponent);
            } else if(preferenceViewModel.BREED_KEY.equals(evt.getPropertyName())) {
                getMatchingController.execute(preferenceViewModel.BREED_KEY, breedInputField.getText());
            } else if (preferenceViewModel.LOCATION_KEY.equals(evt.getPropertyName())) {
                getMatchingController.execute(preferenceViewModel.LOCATION_KEY, locationInputField.getText());
            } else if ("error".equals(evt.getPropertyName())) {
                updateErrorView();
            }
        }

    /**
     * Updates error messages in the UI from the state.
     */
    private void updateErrorView() {
        PreferenceState state = preferenceViewModel.getState();
        minAgeErrorField.setText(state.getMinAgeError());
        maxAgeErrorField.setText(state.getMaxAgeError());
        breedErrorField.setText(state.getBreedError());
        locationErrorField.setText(state.getLocationError());
    }

    /**
     * Updates the suggested popup list with new matching strings from the state.
     * When a user selects a menu item, it sets the current text field's text to the selected option.
     *
     * @param currentComponent The {@code ComponentPair} containing the current text field and popup menu being updated.
     */
    private void updatePopup(ComponentPair currentComponent) {
        JPopupMenu popupMenu = currentComponent.getPopupMenu();
        JTextField textField = currentComponent.getTextField();
        popupMenu.removeAll();
        String input = textField.getText();
        if (input.isEmpty()) {
            popupMenu.setVisible(false);
        } else {
            PreferenceState state = preferenceViewModel.getState();
            List<String> matchingStrings = state.getMatchingStrings();
            if (!matchingStrings.isEmpty()) {
                for (String option : matchingStrings) {
                    JMenuItem item = new JMenuItem(option);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SwingUtilities.invokeLater(() -> {
                                textField.setText(option);
                                popupMenu.setVisible(false);
                            });
                        }
                    });
                    popupMenu.add(item);
                }
                popupMenu.pack();
                popupMenu.show(textField, 0, textField.getHeight());
            } else {
                popupMenu.setVisible(false);
            }
        }
    }

}


