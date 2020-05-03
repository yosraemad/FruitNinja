package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.utils.Utils;
import javafx.scene.control.Label;

/**
 * Created by dc user on 01/05/2020.
 */
public class SliceDoubleScoreListener implements EventListener {
    private Label label;
    private int timeOfShowing = 3000;
    private Utils utils = new Utils();
    public SliceDoubleScoreListener(Label label) {
        this.label = label;
    }

    @Override
    public void update(String eventType, String data) {
        String text = String.format("X2!!");
        label.setText(text);
        utils.showLabelForCertainTime(label, timeOfShowing);
    }
}
