package fruitNinja.models.guiUpdate;

import fruitNinja.models.users.PlayerSingleton;

public class ControlsUpdaterSingleton {

    private volatile static ControlsUpdater controlsUpdaterSingleton;

    private ControlsUpdaterSingleton()
    {

    }

    public static ControlsUpdater getInstance() {
        if (controlsUpdaterSingleton == null) {
            synchronized (PlayerSingleton.class) {
                if (controlsUpdaterSingleton == null)
                    controlsUpdaterSingleton = new ControlsUpdater();
            }
        }

        return controlsUpdaterSingleton;
    }

    public static void setSingleton(ControlsUpdater controlsUpdater)
    {
        controlsUpdaterSingleton = controlsUpdater;
    }
}
