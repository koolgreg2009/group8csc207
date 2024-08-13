package view;

import javax.swing.*;
import java.util.List;

public class PreferenceInputField implements PreferenceTextView{
    private final JTextField textField;
    private final JPopupMenu popupMenu;
    private final String key;

    public PreferenceInputField(JTextField textField, JPopupMenu popupMenu, String key) {
        this.textField = textField;
        this.popupMenu = popupMenu;
        this.key = key;
    }

    @Override
    public String getInputText() {
        return textField.getText();
    }

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

    @Override
    public void clearPopupMenu() {
        popupMenu.removeAll();
    }

    @Override
    public void showPopupMenu() {
        popupMenu.show(textField, 0, textField.getHeight());
    }

    @Override
    public void hidePopupMenu() {
        popupMenu.setVisible(false);
    }
    public String getKey(){
        return key;
    }
}
