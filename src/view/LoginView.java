package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code LoginView} class represents the user interface for logging in.
 * <p>
 * It includes input fields for the username and password, as well as buttons for logging in and signing up.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton signUp;
    private final LoginController loginController;

    /**
     * Constructs a new {@code LoginView} with the specified view models, controller, and view manager.
     *
     * @param loginViewModel   the view model for the login view.
     * @param controller       the controller for handling login actions.
     * @param viewManagerModel the model for managing views.
     * @param signupViewModel  the view model for the signup view.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController controller, ViewManagerModel viewManagerModel,
                     SignupViewModel signupViewModel) {

        this.signupViewModel = signupViewModel;
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(new EmptyBorder(200, 0, 0, 0));
        title.setText("Login Screen");

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        usernameInfo.setBorder(new EmptyBorder(50, 0, 0, 0));
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(loginViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);


        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(logIn)) {
                    LoginState currentState = loginViewModel.getState();
                    loginController.execute(currentState.getUsername().trim(), currentState.getPassword().trim());
                    LoginState clear = new LoginState();
                    loginViewModel.setState(clear);
                    setFields(clear);
                    loginViewModel.firePropertyChanged();
                }
            }
        }
        );

        signUp.addActionListener(
                evt -> {
                    viewManagerModel.setActiveView(signupViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordInputField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            logIn.doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    /**
     * Responds to property change events, updating the UI based on the new login state.
     *
     * @param evt the property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getError() != "") {
            JOptionPane.showMessageDialog(this, state.getError());
        }
    }

    /**
     * Updates the input fields with the specified login state.
     *
     * @param state the login state containing updated username and password.
     */
    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
    }

    /**
     * Handles action events. (Currently not used but included for the ActionListener interface.)
     *
     * @param e the action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}