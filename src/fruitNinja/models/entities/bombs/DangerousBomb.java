package fruitNinja.models.entities.bombs;

import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;

public class DangerousBomb extends Bomb{
    private final int scoreMinimizing = 10;
    private final int timeMinimizing = 10;
    private final int lifeMinimizing = 1;
    public DangerousBomb() {
        super(BombType.DANGEROUS);
        setImage("/fruitNinja/views/images/DangerousBomb.png");
    }

    @Override
    public void slice() {
        super.slice();
        ControlsUpdaterSingleton.getInstance().sliceDangerousBomb(scoreMinimizing);
    }
}
