package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.audios.AudioController;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginView {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button signInBtn;
    @FXML
    private Button signUpBtn;


    public LoginView()
    {

    }

    public void addLoginButtonListener(EventHandler<ActionEvent> event)
    {
        signInBtn.setOnAction(event);
    }

    public void addRegisterButtonListener(EventHandler<ActionEvent> event)
    {
        signUpBtn.setOnAction(event);
    }


    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public PasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(PasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public Button getSignInBtn() {
        return signInBtn;
    }

    public void setSignInBtn(Button signInBtn) {
        this.signInBtn = signInBtn;
    }

    public Button getSignUpBtn() {
        return signUpBtn;
    }

    public void setSignUpBtn(Button signUpBtn) {
        this.signUpBtn = signUpBtn;
    }
}
