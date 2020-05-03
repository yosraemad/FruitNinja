package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.logic.GamePlayActions;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.pages.GameDoneView;
import javafx.stage.Stage;

// CONTROLLER THAT MANAGES THE VIEW THAT APPEARS WHEN THE GAME ENDS
public class GameDoneController extends BaseController {

    private StrategyType strategyType;

    private ScoreRepository scoreRepository = new ScoreRepository();

    private GameDoneView gameDoneView;

    public GameDoneController(GameDoneView gameDoneView, StrategyType strategyType)
    {
        this.gameDoneView = gameDoneView;
        this.strategyType = strategyType;
        init();
    }

    // ALLOWS THE USER TO PLAY ANOTHER GAME
    private void playAgain() {
        Stage stage = (Stage)gameDoneView.getPlayAgainBtn().getScene().getWindow();
        navigation.showGameChoosePage(stage);
        GamePlayActions.isPaused=-1;
    }

    // NAVIGATES THE USER TO THE MAIN MENU
    private void mainMenu() {
        Stage stage;
        stage = (Stage)gameDoneView.getMainMenuBtn().getScene().getWindow();
        navigation.showMainDashboardPage(stage);
        GamePlayActions.isPaused=-1;
    }

    // ADDS THE USER'S SCORES TO THE USER EXPERIENCE SO THAT HE CAN LEVEL UP
    private void addScore()
    {
        scoreRepository.addScore(String.valueOf(PlayerSingleton.getInstance().getCurrentScore()),
                PlayerSingleton.getInstance().getUsername(),strategyType);
    }

    // SETS THE VALUES OF THE USER LATEST SCORE
    private void setScoreValue() {
        gameDoneView.getScoreValue().setText(String.valueOf(PlayerSingleton.getInstance().getCurrentScore()));
    }

    // UPDATES THE USER HIGH SCORE VALUE IF HE BROKE IT
    private void setHighScoreValue()
    {
        ScoreRepository scoreRepository = new ScoreRepository();
        gameDoneView.getHighScoreValue().setText(scoreRepository.getHighScore(strategyType,PlayerSingleton.getInstance().getUsername()));
    }

    // UPDATES THE USER LEVEL
    private void updateLevel()
    {
        PlayerRepository playerRepository = new PlayerRepository();
        playerRepository.updateLevel();
    }

    // SET OF FUNCTIONS THAT GETS CALLED IN THE CONSTRUCTOR
    private void init()
    {
        setEventHandlers();
        addScore();
        setScoreValue();
        setHighScoreValue();
        updateLevel();
    }

    // SETS THE EVENT HANDLERS FOR THE VIEW BUTTONS
    private void setEventHandlers()
    {
        gameDoneView.addPlayAgainButtonListener(event -> playAgain());
        gameDoneView.addMainMenuButtonListener(event -> mainMenu());
    }


}
