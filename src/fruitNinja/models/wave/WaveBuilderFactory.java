package fruitNinja.models.wave;

import fruitNinja.models.modes.StrategyType;

public class WaveBuilderFactory {

    public WaveBuilder createWaveBuilder(StrategyType strategyType)
    {
        if (strategyType == null) throw new NullPointerException();
        switch (strategyType) {
            case CLASSIC:
                return new ClassicWaveBuilder();
            case ARCADE:
                return new ArcadeWaveBuilder();
            case ZEN:
                return new ZenWaveBuilder();
            default:
                return null;
        }
    }
}
