package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.guiUpdate.EventListener;

import java.util.Timer;

public class GameEndListener implements EventListener {

    private Timer timer;

    public GameEndListener(Timer timer)
    {
        this.timer = timer;
    }

    @Override
    public void update(String eventType, String data) {
        timer.cancel();
    }
}
