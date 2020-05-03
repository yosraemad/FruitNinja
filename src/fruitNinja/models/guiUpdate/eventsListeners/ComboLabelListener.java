package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.utils.Utils;
import javafx.scene.control.Label;

import java.util.Timer;

public class ComboLabelListener implements EventListener {

    private Label label;
    private int timeOfShowing = 1500;
    private Utils utils = new Utils();

    public ComboLabelListener(Label label)
    {
        this.label = label;
    }

    @Override
    public void update(String eventType, String data) {
        String text = String.format("%s FRUITS COMBO!!", data);
        label.setText(text);
        utils.showLabelForCertainTime(label, timeOfShowing);
    }
}
