package fruitNinja.views.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameDoneView {
    @FXML
    private Label scoreValue;
    @FXML
    private Label highScoreValue;
    @FXML
    private Button playAgainBtn;
    @FXML
    private Button mainMenuBtn;

    public void addPlayAgainButtonListener(EventHandler<ActionEvent> event)
    {
        playAgainBtn.setOnAction(event);
    }

    public void addMainMenuButtonListener(EventHandler<ActionEvent> event)
    {
        mainMenuBtn.setOnAction(event);
    }

    public Label getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Label scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Label getHighScoreValue() {
        return highScoreValue;
    }

    public void setHighScoreValue(Label highScoreValue) {
        this.highScoreValue = highScoreValue;
    }

    public Button getPlayAgainBtn() {
        return playAgainBtn;
    }

    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn;
    }

    public Button getMainMenuBtn() {
        return mainMenuBtn;
    }

    public void setMainMenuBtn(Button mainMenuBtn) {
        this.mainMenuBtn = mainMenuBtn;
    }
}
