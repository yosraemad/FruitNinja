package fruitNinja.views.pages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class GameChooseView {
    @FXML
    private Button classicButton;
    @FXML
    private Button arcadeButton;
    @FXML
    private Button zenButton;
    @FXML
    private Button exitButton;

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

    public void addExitButtonListener(EventHandler<ActionEvent> event) {exitButton.setOnAction(event);}


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

    public Button getExitButton() {
        return exitButton;
    }

    public void setExitButton(Button exitButton) {
        this.exitButton = exitButton;
    }
}
