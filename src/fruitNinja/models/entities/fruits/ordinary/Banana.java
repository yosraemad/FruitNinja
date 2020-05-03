package fruitNinja.models.entities.fruits.ordinary;

public class Banana extends OrdinaryFruit {
    public Banana(){
        //alternative till finding a way to connect pictures using modleImages class
        setImage("/fruitNinja/views/images/Banana.png");
        setImageAfterSlicing("/fruitNinja/views/images/BananaSliced.png");
    }
}
