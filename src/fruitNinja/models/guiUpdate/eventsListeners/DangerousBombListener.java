package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.models.guiUpdate.EventListener;
import javafx.scene.control.Label;

public class DangerousBombListener implements EventListener {
    private Label scoreLabel;
    private StrategyType strategyType;

    public DangerousBombListener(Label scoreLabel, StrategyType strategyType){
        this.scoreLabel = scoreLabel;
        this.strategyType = strategyType;
    }

    @Override
    public void update(String eventType, String data) {

        if (strategyType.equals(StrategyType.CLASSIC)) {
            ControlsUpdaterSingleton.getInstance().fruitFell(1);
        } else {
            int scoreUpdate = Integer.parseInt(data);
            String newText = String.valueOf(Integer.parseInt(scoreLabel.getText()) - scoreUpdate);
            if (Integer.parseInt(newText) < 0)
                newText = "0";
            scoreLabel.setText(newText);
        }
    }
}
