package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterView {
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button signInBtn;
    @FXML
    private Button signUpBtn;

    public RegisterView()
    {

    }

    public void addRegisterButtonListener(EventHandler<ActionEvent> event)
    {
        signUpBtn.setOnAction(event);
    }

    public void addLoginButtonListener(EventHandler<ActionEvent> event)
    {
        signInBtn.setOnAction(event);
    }

    public TextField getFullNameTextField() {
        return fullNameTextField;
    }

    public void setFullNameTextField(TextField fullNameTextField) {
        this.fullNameTextField = fullNameTextField;
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
