package fruitNinja.models.modes;

import fruitNinja.models.modes.Stratgies.GameStrategy;
import fruitNinja.models.modes.Stratgies.TimerStrategy;
import javafx.scene.canvas.Canvas;

// CONTEXT FOR THE STRATEGY CLASSES THAT MANAGES WHICH GETS RUN ON RUNTIME
public class ModeContext {
    private GameStrategy gameStrategy;

    public ModeContext(GameStrategy gameStrategy)
    {
        this.gameStrategy = gameStrategy;
    }

    // A FUNCTION THAT STARTS THE GAME WITH THE REQUIRED STRATEGY
    public void startGame(Canvas canvas) {
        gameStrategy.initGame(canvas);
        if (!gameStrategy.getStrategyType().equals(StrategyType.CLASSIC)) {
            TimerStrategy timerStrategy = (TimerStrategy) gameStrategy;
            timerStrategy.startCustomTimer();
        }
    }
}
