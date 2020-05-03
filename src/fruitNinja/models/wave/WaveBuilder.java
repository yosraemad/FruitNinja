package fruitNinja.models.wave;

import fruitNinja.models.Difficulty;

public interface WaveBuilder {
    void setDifficulty(Difficulty difficulty);
    void buildFruits();
    void buildSpecialFruits();
    void buildBombs();
    void shuffleWave();
    Wave getWave();
}
