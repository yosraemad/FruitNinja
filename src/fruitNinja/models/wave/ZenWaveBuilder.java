package fruitNinja.models.wave;

import fruitNinja.models.Difficulty;
import fruitNinja.models.entities.fruits.Fruit;
import fruitNinja.models.entities.Sprite;

import java.util.ArrayList;
import java.util.Collections;

public class ZenWaveBuilder extends WaveBuilderBase {

    public ZenWaveBuilder()
    {
        wave = new Wave();
        wave.setWaveObjects(new ArrayList<>());
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        wave.setDifficulty(difficulty);
    }

    @Override
    public void buildFruits() {
        int n = utils.generateRandomFruitNumBasedOnDifficulty(wave.getDifficulty());
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < n; i++)
            fruits.add(randomObjectGenerator.generateRandomFruit());

        wave.addFruits(fruits);
    }

    @Override
    public void buildSpecialFruits() {

    }

    @Override
    public void buildBombs() {

    }

    @Override
    public void shuffleWave() {
        ArrayList<Sprite> waveObjects = wave.getWaveObjects();
        Collections.shuffle(waveObjects);
        wave.setWaveObjects(waveObjects);

    }

    @Override
    public Wave getWave() {
        return wave;
    }
}
