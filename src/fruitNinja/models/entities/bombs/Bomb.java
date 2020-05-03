package fruitNinja.models.entities.bombs;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.entities.Sprite;

public abstract class Bomb extends Sprite {
    private BombType bombType;
    private final AudioController audioController = new AudioController();
    public Bomb(BombType bombType){
        this.bombType = bombType;
    }
    @Override
    public void slice()
    {
        audioController.start("bomb");
        setSliced(true);
    }
}
