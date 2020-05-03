package fruitNinja.models.entities.fruits;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fruit")
@XmlAccessorType(XmlAccessType.FIELD)
public class FruitData {
    @XmlElement(name="fruitname")
    private String fruitname;
    @XmlElement(name = "picture")
    private String picture;

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture= picture;
    }
}
