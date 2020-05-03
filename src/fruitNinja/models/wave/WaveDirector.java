package fruitNinja.models.wave;

import fruitNinja.models.Difficulty;

public class WaveDirector {
    private WaveBuilder waveBuilder;
    private Difficulty difficulty;

    public WaveDirector(WaveBuilder waveBuilder, Difficulty difficulty)
    {
        this.waveBuilder = waveBuilder;
        this.difficulty = difficulty;
    }

    public Wave getWave()
    {
        return waveBuilder.getWave();
    }

    public void constructWave()
    {
        waveBuilder.setDifficulty(difficulty);
        waveBuilder.buildFruits();
        waveBuilder.buildBombs();
        waveBuilder.buildSpecialFruits();
        waveBuilder.shuffleWave();
    }
}
