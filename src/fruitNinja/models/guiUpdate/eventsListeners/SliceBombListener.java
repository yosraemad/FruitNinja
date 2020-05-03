package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.views.guiUtils.Navigation;
import javafx.stage.Stage;

public class SliceBombListener implements EventListener {
    private final Stage stage;
    private final StrategyType strategyType;

    public SliceBombListener(Stage stage, StrategyType strategyType){
        this.stage = stage;
        this.strategyType = strategyType;
    }

    @Override
    public void update(String eventType, String data) {
        Navigation navigation = new Navigation();
        navigation.showGameOverPage(stage,strategyType);
    }
}
