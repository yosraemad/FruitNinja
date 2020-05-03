package fruitNinja.views.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GameView {

    @FXML
    private Button pauseButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label livesLabel;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Label comboLabel;
    @FXML
    private Label scoreX2Label;
    @FXML
    private Canvas canvas;

    public Label getScoreX2Label() {
        return scoreX2Label;
    }

    public void setScoreX2Label(Label scoreX2Label) {
        this.scoreX2Label = scoreX2Label;
    }

    public Label getHighScoreLabel() {
        return highScoreLabel;
    }

    public void setHighScoreLabel(Label highScoreLabel) {
        this.highScoreLabel = highScoreLabel;
    }


    public void addPauseButtonListener(EventHandler<ActionEvent> event) {
        pauseButton.setOnAction(event);
    }


    public Button getPauseButton() {
        return pauseButton;
    }

    public void setPauseButton(Button pauseButton) {
        this.pauseButton = pauseButton;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public void setTimerLabel(Label timerLabel) {
        this.timerLabel = timerLabel;
    }

    public Label getLivesLabel() {
        return livesLabel;
    }

    public void setLivesLabel(Label livesLabel) {
        this.livesLabel = livesLabel;
    }

    public Label getComboLabel() {
        return comboLabel;
    }

    public void setComboLabel(Label comboLabel) {
        this.comboLabel = comboLabel;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
