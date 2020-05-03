package fruitNinja.models.entities.bombs;

import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;

public class FatalBomb extends Bomb {

    public FatalBomb() {
        super(BombType.FATAL);
        setImage("/fruitNinja/views/images/FatalBomb.png");
    }

    @Override
    public void slice(){
        ControlsUpdaterSingleton.getInstance().sliceFatalBomb();
    }
}
