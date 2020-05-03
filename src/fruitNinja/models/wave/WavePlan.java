package fruitNinja.models.wave;

import fruitNinja.models.entities.bombs.Bomb;
import fruitNinja.models.entities.fruits.Fruit;

import java.util.ArrayList;

public interface WavePlan {
    void addFruits(ArrayList<Fruit> fruits);
    void addBombs(ArrayList<Bomb> bombs);
}
