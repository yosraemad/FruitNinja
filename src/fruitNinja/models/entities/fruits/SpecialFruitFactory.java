package fruitNinja.models.entities.fruits;

import fruitNinja.models.entities.fruits.special.DoubleScore;
import fruitNinja.models.entities.fruits.special.Freeze;
import fruitNinja.models.entities.fruits.special.Frenzy;

class SpecialFruitFactory {
    public Fruit createFruit(String specialFruitName)
    {
        Fruit fruit;
        switch (specialFruitName.toLowerCase())
        {
            case "frenzy":
                fruit = new Frenzy();
                break;

            case "doublescore":
                fruit = new DoubleScore();
                break;
            case"freeze":
                fruit=new Freeze();
                break;
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.SPECIAL);
        return fruit;
    }
}
