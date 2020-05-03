package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Validation;
import fruitNinja.views.pages.RegisterView;
import javafx.stage.Stage;

// CONTROLLER THAT MANAGES THE VIEW IN WHICH THE USER SIGNS UP
public class RegisterController extends BaseController {

    private RegisterView registerView;
    private PlayerRepository playerRepository  = new PlayerRepository();

    public RegisterController(RegisterView registerView)
    {
        this.registerView = registerView;
        setEventHandlers();
    }

    // VALIDATES THE USER INPUT
    private boolean validateInput()
    {
        Validation validations = new Validation();
        validations.validateEmptyTextFields(registerView.getFullNameTextField(),registerView.getUsernameTextField(),registerView.getPasswordTextField());
        validations.validateFullNameTextField(registerView.getFullNameTextField());
        validations.validateUsernameTextField(registerView.getUsernameTextField());
        validations.validatePasswordField(registerView.getPasswordTextField());


        return !validations.getFlag();
    }

    // SIGNS UP NEW USER TO THE GAME AND NAVIGATES HIM TO THE MAIN DASHBOARD
    private void signUp() {

        if (validateInput()) {

            String fullName = registerView.getFullNameTextField().getText();
            String username = registerView.getUsernameTextField().getText();
            String password = registerView.getPasswordTextField().getText();
            Player player = playerRepository.signUp(fullName, username, password);

            if (player == null) {
                alerts.showErrorAlert("Invalid data", "User with the same username already exists");
                return;
            }

            PlayerSingleton.setPlayerSingleton(player);

            Stage stage = (Stage) registerView.getSignUpBtn().getScene().getWindow();
            navigation.showMainDashboardPage(stage);
        }
    }

    // NAVIGATES USER TO THE LOGIN PAGE
    private void login() {
        Stage stage = (Stage) registerView.getSignInBtn().getScene().getWindow();
        navigation.showLoginPage(stage);
    }

    // SETS THE EVENT HANDLERS FOR THE VIEW BUTTONS
    private void setEventHandlers()
    {
        this.registerView.addRegisterButtonListener(actionEvent -> signUp());
        this.registerView.addLoginButtonListener(actionEvent -> login());
    }
}
