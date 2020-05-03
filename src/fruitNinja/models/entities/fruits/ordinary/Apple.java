package fruitNinja.models.entities.fruits.ordinary;

public class Apple extends OrdinaryFruit {
    //alternative till finding a way to connect pictures using modleImages class
    public Apple() {
        setImage("/fruitNinja/views/images/Apple.png");
        setImageAfterSlicing("/fruitNinja/views/images/AppleSliced.png");
    }
}
