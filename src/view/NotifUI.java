package view;

import interface_adapter.adopt.AdoptController;
import interface_adapter.adopt.AdoptViewModel;

import javax.swing.*;
import java.awt.*;

public class NotifUI {
    private AdoptController adoptController;
    private AdoptViewModel adoptViewModel;

    public NotifUI(AdoptController adoptController, AdoptViewModel adoptViewModel){
        this.adoptController = adoptController;
        this.adoptViewModel = adoptViewModel;

        JLabel title = new JLabel("Adopt message");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        okay = new JButton(AdoptViewModel.OKAYGE_BUTTON);
        buttons.add(okay);
    }
}
