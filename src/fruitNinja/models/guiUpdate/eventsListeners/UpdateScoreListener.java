package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.models.users.PlayerSingleton;
import javafx.scene.control.Label;

public class UpdateScoreListener implements EventListener {

    private Label label;

    public UpdateScoreListener(Label label)
    {
        this.label = label;
    }

    @Override
    public void update(String eventType, String text) {
        int scoreUpdate = Integer.parseInt(text);
        String newText = String.valueOf(Integer.parseInt(label.getText()) + scoreUpdate);
        label.setText(newText);
        PlayerSingleton.getInstance().setCurrentScore(Integer.parseInt(newText));
    }
}
