package fruitNinja.controllers;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.MainDashboardView;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// CONTROLLER THAT MANAGES THE VIEW IN WHICH THE MAIN MENU IS DISPLAYED
public class MainDashboardController extends BaseController {

    private Player player;
    private MainDashboardView mainDashboardView;

    public MainDashboardController(MainDashboardView mainDashboardView)
    {
        this.mainDashboardView = mainDashboardView;
        player = PlayerSingleton.getInstance();
        setEventHandlers();
        setLevel();
        setAudio();
    }

    // NAVIGATES THE USER BACK TO THE LOGIN PAGE
    private void back() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showLoginPage(stage);
    }

    // NAVIGATES THE USER TO THE LEADERBOARD OF SCORES
    private void leaderBoard() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showLeaderboardPage(stage);
    }

    // NAVIGATES THE USER TO THE PAGE IN WHICH HE GETS TO PICK THE GAME MODE FOR HIS NEW GAME
    private void newGame() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showGameChoosePage(stage);
    }

    // SETS THE LEVEL OF THE LOGGED IN USER TO THE LABEL
    private void setLevel()
    {
        int levelMaxPoints = utils.calculateExperiencePoints(player.getLevel());
        double percentage = player.getExperience() * 1.0 / levelMaxPoints;
        mainDashboardView.getLevelBar().setProgress(percentage);
        mainDashboardView.getLevel().setText(String.valueOf(player.getLevel()));
        mainDashboardView.getPlayerName().setText("Player: " + player.getFullName());
    }

    // STARTS THE GAME MUSIC
    private void setAudio() {
        audioController = new AudioController();
        audioController.start("start");
    }

    // SETS THE EVENT HANDLERS FOR VIEW BUTTONS
    private void setEventHandlers()
    {
        this.mainDashboardView.addNewGameButtonListener(actionEvent -> newGame());
        this.mainDashboardView.addLeaderBoardButtonListener(actionEvent -> leaderBoard());
        this.mainDashboardView.addBackButtonListener(actionEvent -> back());
    }
}
