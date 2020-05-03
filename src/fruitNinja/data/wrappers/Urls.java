package fruitNinja.data.wrappers;
import fruitNinja.models.entities.fruits.FruitData;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "fruits")
@XmlAccessorType(XmlAccessType.FIELD)
public class Urls {
    @XmlElement(name = "fruit")
    private ArrayList<FruitData>fruitData ;

    public ArrayList<FruitData> getFruitData() {
        return fruitData;
    }

    public void setFruitData(ArrayList<FruitData> fruitData) {
        this.fruitData = fruitData;
    }



}
