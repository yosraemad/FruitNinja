package fruitNinja.models.logic;

import fruitNinja.models.modes.StrategyType;
import javafx.scene.canvas.Canvas;

import java.util.TimerTask;

// TIMER TASK WHICH RUNS THE GAME CYCLE OVER AND OVER AGAIN
public class Round extends TimerTask {

    private GamePlayActions gamePlayActions;
    private GameLogic gameLogic;
    private GameProperties gameProperties;

    public Round(Canvas canvas, StrategyType strategyType )
    {
        gamePlayActions = new GamePlayActions();
        gamePlayActions.setCanvas(canvas);
        gameLogic = new GameLogic(strategyType);
        gameProperties = new GameProperties();
    }

    @Override
    public void run() {
        gameLogic.startRound(gameProperties, gamePlayActions);
    }

}
