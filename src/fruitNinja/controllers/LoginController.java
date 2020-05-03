package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.audios.AudioController;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.LoginView;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// CONTROLLER THAT MANAGES THE VIEW IN WHICH THE USER LOGS IN
public class LoginController extends BaseController {

    private PlayerRepository playerRepository = new PlayerRepository();
    private LoginView loginView;


    public LoginController(LoginView loginView)
    {
        setAudio();
        this.loginView = loginView;
        setEventHandlers();
    }

    // LOGIN THE USER INTO THE SYSTEM AND NAVIGATES HIM TO THE MAIN DASHBOARD AND SHOWS AN ERROR IF HE ENTERS WRONG CREDENTIALS
    private void login()
    {
        // TODO: Validations to be made

        String username = loginView.getUsernameTextField().getText();
        String password = loginView.getPasswordTextField().getText();

        Player player = playerRepository.login(username, password);

        if (player == null) {
            alerts.showErrorAlert("Invalid Credentials", "Wrong username or password");
            return;
        }

        PlayerSingleton.setPlayerSingleton(player);

        Stage stage = (Stage) loginView.getSignUpBtn().getScene().getWindow();
        audioController.stop();
        navigation.showMainDashboardPage(stage);
    }

    // NAVIGATES THE USER TO THE REGISTER PAGE
    private void signUp()
    {
        Stage stage = (Stage) loginView.getSignUpBtn().getScene().getWindow();
        audioController.stop();
        navigation.showRegisterPage(stage);
    }

    // PLAYS THE GAME MUSIC
    private void setAudio() {
        audioController = new AudioController();
        audioController.start("start");
    }

    // SETS THE EVENT HANDLERS FOR THE VIEW BUTTONS
    private void setEventHandlers()
    {
        this.loginView.addLoginButtonListener(actionEvent -> login());
        this.loginView.addRegisterButtonListener(actionEvent -> signUp());
    }


}
