package fruitNinja.views.pages;

import fruitNinja.models.logic.GamePlayActions;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.states.GameState;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.Score;
import fruitNinja.utils.CustomTimer;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class PauseDialogController {
    public  Button quitBtn;
    private Player player;
    private GameState gameState;
    private StrategyType strategyType;
    private Score score;
    private String time;

    Navigation navigation=new Navigation();

    public PauseDialogController(GameState gameState, StrategyType strategyType, Score score, String time) {
        this.score=score;
        this.gameState = gameState;
        this.strategyType=strategyType;
        this.time=time;
    }

    Stage stage = new Stage();
    private Window window;



    public void show(Window window) throws IOException {
        this.window = window;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseDialog.fxml"));
        loader.setController(this);
        GridPane grid = loader.load();
        Scene scene = new Scene(grid,700,600);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(window);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }


    public void quitBtnClicked(ActionEvent actionEvent) throws IOException {
        GamePlayActions.isPaused = -1;
        stage = (Stage)quitBtn.getScene().getWindow();
        stage.close();
        this.stage = (Stage) window;
        navigation.showGameDonePage(stage,strategyType);
    }

    public void restartBtnClicked(ActionEvent actionEvent){
        GamePlayActions.isPaused = 0;
        stage = (Stage)quitBtn.getScene().getWindow();
        stage.close();
        this.stage = (Stage) window;
        navigation.showGamePage(stage,strategyType);
        gameState.clickPlay();
    }

    public void resumeBtnClicked(ActionEvent actionEvent) {
        GamePlayActions.isPaused = 0;
        stage =(Stage)quitBtn.getScene().getWindow();
        stage.close();
        this.stage = (Stage) window;
        if(!strategyType.equals(StrategyType.CLASSIC)){
            CustomTimer customTimer=new CustomTimer(Integer.parseInt(time)-1,stage,strategyType);
            customTimer.initCustomTimer();
        }

        gameState.clickPlay();
    }

}
