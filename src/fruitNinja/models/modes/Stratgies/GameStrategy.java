package fruitNinja.models.modes.Stratgies;

import fruitNinja.models.modes.StrategyType;
import javafx.scene.canvas.Canvas;

public interface GameStrategy {
    void initGame(Canvas canvas);
    StrategyType getStrategyType();
}
