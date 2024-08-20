package view;

import javax.swing.*;

/**
 * The {@code ComponentPair} class represents a pair consisting of a {@code JTextField} and a {@code JPopupMenu}.
 * <p>
 * It provides a way to associate a text field with a popup menu, encapsulating these components into a single object.
 */
public class ComponentPair{
    private JTextField textField;
    private JPopupMenu comboBox;

    /**
     * Constructs a {@code ComponentPair} with the specified text field and popup menu.
     *
     * @param textField the {@code JTextField} to be associated with the popup menu.
     * @param comboBox  the {@code JPopupMenu} to be associated with the text field.
     */
    public ComponentPair(JTextField textField, JPopupMenu comboBox) {
        this.textField = textField;
        this.comboBox = comboBox;
    }

    /**
     * Returns the {@code JTextField} associated with this pair.
     *
     * @return the {@code JTextField}.
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * Returns the {@code JPopupMenu} associated with this pair.
     *
     * @return the {@code JPopupMenu}.
     */
    public JPopupMenu getPopupMenu() {
        return comboBox;
    }
}
