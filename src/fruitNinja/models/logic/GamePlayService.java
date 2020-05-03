package fruitNinja.models.logic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.entities.Sprite;
import fruitNinja.models.wave.WaveBuilder;
import fruitNinja.models.wave.WaveBuilderFactory;
import fruitNinja.models.wave.WaveDirector;


import java.util.ArrayList;


public class GamePlayService {

    // GENERATES WAVE (ARRAYLIST OF FRUITS AND BOMBS) DEPENDING ON MODE
    public ArrayList<Sprite> generateWave(StrategyType strategyType, Difficulty difficulty) {
        WaveBuilderFactory waveBuilderFactory =  new WaveBuilderFactory();
        WaveBuilder waveBuilder = waveBuilderFactory.createWaveBuilder(strategyType);
        WaveDirector waveDirector = new WaveDirector(waveBuilder, difficulty);
        waveDirector.constructWave();
        return waveDirector.getWave().getWaveObjects();
    }
}
