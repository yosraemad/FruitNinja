package fruitNinja.data.wrappers;

import fruitNinja.models.users.Player;
import fruitNinja.models.users.Score;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

// WRAPPER CLASS FOR SCORE CLASS USED FOR JAXB LIBRARY
@XmlRootElement(name="scores")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scores {
    @XmlElement(name ="score")
    private ArrayList<Score> scores;
    public ArrayList<Score> getScores() {
        return scores;
    }
    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }
}
