package fruitNinja.utils.events;

import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseReleaseEvent implements EventHandler<MouseEvent> {

    private MouseDraggedEvent mouseDraggedEvent;

    public MouseReleaseEvent(MouseDraggedEvent mouseDraggedEvent)
    {
        this.mouseDraggedEvent = mouseDraggedEvent;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        int combo = mouseDraggedEvent.getComboCount();
        boolean on=mouseDraggedEvent.isOn();
        if (combo > 2) {
            ControlsUpdaterSingleton.getInstance().comboSliced(combo);
            ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(combo);
        }
        mouseDraggedEvent.setComboCount(0);
    }
}
