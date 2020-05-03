package fruitNinja.controllers;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.views.pages.GameChooseView;
import javafx.stage.Stage;

// CONTROLLER THAT MANAGES THE VIEW IN WHICH THE USER CHOOSES THE GAME MODE
public class GameChooseController extends BaseController {

    private GameChooseView gameChooseView;

    public GameChooseController(GameChooseView gameChooseView)
    {
        this.gameChooseView = gameChooseView;
        setEventHandlers();
        settAudio();
    }

    // STARTS GAME WITH ZEN MODE
    private void zenMode() {
        audioController.stop();
        navigateToGame(StrategyType.ZEN);
    }

    // STARTS GAME WITH CLASSIC MODE
    private void classicMode() {
        audioController.stop();
        navigateToGame(StrategyType.CLASSIC);
    }

    //STARTS GAME WITH ARCADE MODE
    private void arcadeMode() {
        audioController.stop();
        navigateToGame(StrategyType.ARCADE);
    }

    // EXIT THE GAME CHOOSE WINDOW AND RETURN TO PREV PAGE
    private void exit() {
        audioController.stop();
        navigation.showMainDashboardPage((Stage) gameChooseView.getClassicButton().getScene().getWindow());
    }

    // STARTS GAME WITH THE PROVIDED STRATEGY TYPE
    private void navigateToGame(StrategyType strategyType)
    {
        audioController.stop();
        Stage stage = (Stage)gameChooseView.getClassicButton().getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }

    // STARTS THE GAME MUSIC
    private void settAudio() {
        audioController = new AudioController();
        audioController.start("start");
    }

    // SETS THE EVENT HANDLERS FOR THE VIEW BUTTONS
    private void setEventHandlers()
    {
        gameChooseView.addArcadeButtonListener(event -> arcadeMode());
        gameChooseView.addClassicButtonListener(event -> classicMode());
        gameChooseView.addZenButtonListener(event -> zenMode());
        gameChooseView.addExitButtonListener(event -> exit());
    }
}
