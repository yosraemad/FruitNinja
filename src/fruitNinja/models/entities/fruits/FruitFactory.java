package fruitNinja.models.entities.fruits;

public class FruitFactory {
    private Fruit fruit;

    public FruitFactory()
    {

    }

    public Fruit createFruit(String fruitName, FruitType fruitType)
    {
        return createFruit(fruitName, fruitType.toString());
    }

    public Fruit createFruit(String fruitName, String fruitType)
    {
        if (fruitName == null) throw new NullPointerException();

        Fruit fruit;
        if (fruitType.toLowerCase().equals("ordinary"))
        {
            OrdinaryFruitFactory ordinaryFruitFactory = new OrdinaryFruitFactory();
            fruit = ordinaryFruitFactory.createFruit(fruitName);
        }
        else {
            SpecialFruitFactory specialFruitFactory = new SpecialFruitFactory();
            fruit = specialFruitFactory.createFruit(fruitName);
        }

        return fruit;
    }
}
