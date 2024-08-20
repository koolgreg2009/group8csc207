package view;

import javax.swing.*;
import java.util.List;

/**
 * A class that represents a text field with an associated popup menu for displaying suggestions.
 * This class implements the {@code PreferenceTextView} interface.
 */
public class PreferenceInputField implements PreferenceTextView{
    private final JTextField textField;
    private final JPopupMenu popupMenu;
    private final String key;

    /**
     * Constructs a {@code PreferenceInputField} with the specified text field, popup menu, and key.
     *
     * @param textField the {@code JTextField} used for input.
     * @param popupMenu the {@code JPopupMenu} used to display suggestions.
     * @param key a {@code String} representing a unique key associated with this input field.
     */
    public PreferenceInputField(JTextField textField, JPopupMenu popupMenu, String key) {
        this.textField = textField;
        this.popupMenu = popupMenu;
        this.key = key;
    }

    /**
     * Retrieves the current text from the input field.
     *
     * @return the text currently entered in the input field.
     */
    @Override
    public String getInputText() {
        return textField.getText();
    }

    /**
     * Updates the popup menu with the provided list of matching strings.
     * Clears the existing items and adds new items based on the {@code matchingStrings} list.
     *
     * @param matchingStrings a {@code List} of {@code String} items to be displayed in the popup menu.
     */
    @Override
    public void updatePopupMenu(List<String> matchingStrings) {
        popupMenu.removeAll();
        for (String option : matchingStrings) {
            JMenuItem item = new JMenuItem(option);
            item.addActionListener(e -> {
                textField.setText(option);
                hidePopupMenu();
            });
            popupMenu.add(item);
        }
        showPopupMenu();
    }

    /**
     * Clears all items from the popup menu.
     */
    @Override
    public void clearPopupMenu() {
        popupMenu.removeAll();
    }

    /**
     * Displays the popup menu below the text field.
     */
    @Override
    public void showPopupMenu() {
        popupMenu.show(textField, 0, textField.getHeight());
    }

    /**
     * Hides the popup menu.
     */
    @Override
    public void hidePopupMenu() {
        popupMenu.setVisible(false);
    }

    /**
     * Retrieves the unique key associated with this input field.
     *
     * @return the key as a {@code String}.
     */
    public String getKey(){
        return key;
    }
}
