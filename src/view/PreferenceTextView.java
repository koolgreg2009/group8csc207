package view;
import java.util.List;

/**
 * An interface for a view component that handles text input and displays a popup menu
 * with suggestions based on the input text.
 */
public interface PreferenceTextView {

    /**
     * Retrieves the current text from the input field.
     *
     * @return the text currently entered in the input field.
     */
    String getInputText();

    /**
     * Updates the popup menu with the provided list of matching strings.
     * Clears the existing items and adds new items based on the {@code matchingStrings} list.
     *
     * @param matchingStrings a {@code List} of {@code String} items to be displayed in the popup menu.
     */
    void updatePopupMenu(List<String> matchingStrings);

    /**
     * Clears all items from the popup menu.
     */
    void clearPopupMenu();

    /**
     * Displays the popup menu.
     */
    void showPopupMenu();

    /**
     * Hides the popup menu.
     */
    void hidePopupMenu();
}
