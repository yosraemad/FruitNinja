package fruitNinja.models.entities.fruits;

import fruitNinja.models.entities.fruits.ordinary.Apple;
import fruitNinja.models.entities.fruits.ordinary.Banana;
import fruitNinja.models.entities.fruits.ordinary.Pineapple;

class OrdinaryFruitFactory {

    public OrdinaryFruitFactory()
    {
    }

    public Fruit createFruit(String ordinaryFruitName)
    {
        Fruit fruit;
        switch (ordinaryFruitName.toLowerCase())
        {
            case "banana":
                fruit = new Banana();
                break;

            case "apple":
                fruit = new Apple();
                break;

            case "pineapple":
                fruit = new Pineapple();
                break;
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.ORDINARY);
        return fruit;
    }
}
