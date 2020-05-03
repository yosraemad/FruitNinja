package fruitNinja.models.modes.Stratgies;

import fruitNinja.models.modes.StrategyType;
import fruitNinja.utils.CustomTimer;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public abstract class BaseTimerStrategy extends BaseStrategy implements TimerStrategy {
    private final int time = 60;
    private Stage stage;
    public BaseTimerStrategy(StrategyType strategyType){
        super(strategyType);
    }
    @Override
    public void initGame(Canvas canvas){
        setStage(canvas);
        super.initGame(canvas);
    }

    @Override
    public void startCustomTimer() {
        CustomTimer customTimer = new CustomTimer(time,stage,super.getStrategyType());
        customTimer.initCustomTimer();
    }

    private void setStage(Canvas canvas) {
        this.stage = (Stage) canvas.getScene().getWindow();
    }
}
