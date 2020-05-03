package fruitNinja.views.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dc user on 30/04/2020.
 */
public class LeaderboardView{
    @FXML
    private Button classicButton;

    @FXML
    private Button arcadeButton;

    @FXML
    private Button zenButton;

    @FXML
    private Button backButton;

    @FXML
    private Label names;

    @FXML
    private Label scores;

    public void addClassicButtonListener(EventHandler<ActionEvent> event)
    {
        classicButton.setOnAction(event);
    }
    public void addArcadeButtonListener(EventHandler<ActionEvent> event)
    {
        arcadeButton.setOnAction(event);
    }
    public void addZenButtonListener(EventHandler<ActionEvent> event)
    {
        zenButton.setOnAction(event);
    }
    public void addBackButtonListener(EventHandler<ActionEvent> event)
    {
        backButton.setOnAction(event);
    }

    public Button getClassicButton() {
        return classicButton;
    }

    public void setClassicButton(Button classicButton) {
        this.classicButton = classicButton;
    }

    public Button getArcadeButton() {
        return arcadeButton;
    }

    public void setArcadeButton(Button arcadeButton) {
        this.arcadeButton = arcadeButton;
    }

    public Button getZenButton() {
        return zenButton;
    }

    public void setZenButton(Button zenButton) {
        this.zenButton = zenButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Label getNames() {
        return names;
    }

    public void setNames(Label names) {
        this.names = names;
    }

    public Label getScores() {
        return scores;
    }

    public void setScores(Label scores) {
       this.scores = scores;
    }
}
