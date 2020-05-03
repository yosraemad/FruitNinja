package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.views.guiUtils.Navigation;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static fruitNinja.models.logic.GamePlayActions.isPaused;

public class LivesLabelListener implements EventListener {

    private Label label;
    private final Stage stage;

    public LivesLabelListener(Stage stage,Label label)
    {
        this.label = label;
        this.stage=stage;
    }

    Navigation navigation = new Navigation();

    @Override
    public void update(String eventType, String data) {

        String lives = label.getText();
        lives += "X";
        label.setText(lives);
        System.out.println(lives);
        if (lives.equals("XXX")) {
            label.setText("");
            isPaused = -1;
            navigation.showGameOverPage(stage, StrategyType.CLASSIC);
        }
    }
}
