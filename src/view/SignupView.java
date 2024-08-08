package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.preference.PreferenceViewModel;

/**
 * The SignupView class represents the UI for user sign-up.
 * It includes input fields for username, password, repeated password, name, email, and phone.
 * It also includes buttons to sign up or cancel the operation.
 *
 * @version 1.0
 * @since 2024-08-08
 */
public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JTextField nameInputField = new JTextField(15);
    private final JTextField emailInputField = new JTextField(15);
    private final JTextField phoneInputField = new JTextField(15);
    private final SignupController signupController;
    private final LoginViewModel loginViewModel;
    private final PreferenceViewModel preferenceViewModel;
    private final ViewManagerModel viewManagerModel;


    private final JButton signUp;
    private final JButton cancel;

    /**
     * Constructs a new SignupView with the specified controller and view models.
     *
     * @param controller
     * @param signupViewModel
     * @param viewManagerModel
     * @param loginViewModel
     * @param preferenceViewModel
     */
    public SignupView(SignupController controller, SignupViewModel signupViewModel, ViewManagerModel viewManagerModel,
                      LoginViewModel loginViewModel, PreferenceViewModel preferenceViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);
        this.loginViewModel = loginViewModel;
        this.preferenceViewModel = preferenceViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel(signupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        LabelTextPanel fullnameInfo = new LabelTextPanel(
                new JLabel(signupViewModel.NAME_LABEL), nameInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel(signupViewModel.EMAIL_LABEL), emailInputField);
        LabelTextPanel phoneInfo = new LabelTextPanel(
                new JLabel(signupViewModel.PHONE_LABEL), phoneInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(signupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(signupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState currentState = signupViewModel.getState();
                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword(),
                                    currentState.getName(),
                                    currentState.getEmail(),
                                    currentState.getPhone()
                            );

                        }
                    }
                }
        );

        cancel.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(loginViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(String.valueOf(passwordInputField.getPassword()) + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(String.valueOf(repeatPasswordInputField.getPassword()) + e.getKeyChar());

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setName(nameInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        emailInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setEmail(emailInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        phoneInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPhone(phoneInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(fullnameInfo);
        this.add(emailInfo);
        this.add(phoneInfo);
        this.add(buttons);
    }


    /**
     * React to a button click that results in an action event.
     *
     * @param evt
     */
    @Override
	public void actionPerformed(ActionEvent evt) {
		signupController.execute(usernameInputField.getText(), String.valueOf(passwordInputField.getPassword()),
				String.valueOf(repeatPasswordInputField.getPassword()), emailInputField.getText(),
                phoneInputField.getText(),
                usernameInputField.getText());
    }

    /**
     * Respond to property change events to update the view based on the new state.
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}
