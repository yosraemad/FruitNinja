package fruitNinja.models.entities.fruits;

import fruitNinja.models.entities.Sprite;

public abstract class Fruit extends Sprite {
    private String imageAfterSlicing;
    private FruitType fruitType;

    public String getImageAfterSlicing() {
        return imageAfterSlicing;
    }

    public void setImageAfterSlicing(String imageAfterSlicing) {
        this.imageAfterSlicing = imageAfterSlicing;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        setSliced(true);
    }
}
