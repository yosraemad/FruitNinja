package fruitNinja.models.wave;

import fruitNinja.models.entities.bombs.BombFactory;
import fruitNinja.utils.RandomObjectGenerator;
import fruitNinja.utils.Utils;

public abstract class WaveBuilderBase implements WaveBuilder {
    protected Wave wave;
    protected RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
    protected Utils utils = new Utils();
    protected BombFactory bombFactory = new BombFactory();
}
