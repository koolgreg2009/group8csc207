package view;

import javax.swing.*;

/**
 * The {@code LabelTextPanel} class represents a panel containing a label and a text field (or any other {@code JComponent}).
 * <p>
 * This panel arranges the label and the component in a horizontal layout.
 */
class LabelTextPanel extends JPanel {

    /**
     * Constructs a {@code LabelTextPanel} with the specified label and component.
     * <p>
     * Adds the label and component to the panel in the order they are provided.
     *
     * @param label    the {@code JLabel} to be added to the panel.
     * @param component the {@code JComponent} (e.g., {@code JTextField}) to be added to the panel.
     */
    LabelTextPanel(JLabel label, JComponent component) {
        this.add(label);
        this.add(component);
    }
}
