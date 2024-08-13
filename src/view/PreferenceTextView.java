package view;
import java.util.List;

public interface PreferenceTextView {
    String getInputText();
    void updatePopupMenu(List<String> matchingStrings);
    void clearPopupMenu();
    void showPopupMenu();
    void hidePopupMenu();
}
