package fruitNinja.models.entities.fruits.ordinary;

public class Pineapple extends OrdinaryFruit {
    //alternative till finding a way to connect pictures using modleImages class
    public Pineapple() {
        setImage("/fruitNinja/views/images/Pineapple.png");
        setImageAfterSlicing("/fruitNinja/views/images/PineappleSliced.png");
    }
}
