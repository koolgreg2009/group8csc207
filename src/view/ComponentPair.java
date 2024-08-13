package view;

import javax.swing.*;

public class ComponentPair{
    private JTextField textField;
    private JPopupMenu comboBox;

    public ComponentPair(JTextField textField, JPopupMenu comboBox) {
        this.textField = textField;
        this.comboBox = comboBox;
    }

    public JTextField getTextField() {
        return textField;
    }
    public JPopupMenu getPopupMenu() {
        return comboBox;
    }
}
