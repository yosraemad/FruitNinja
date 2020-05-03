package fruitNinja.data.wrappers;

import fruitNinja.models.users.Player;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

// WRAPPER CLASS FOR PLAYER CLASS USED FOR JAXB LIBRARY
@XmlRootElement(name="players")
@XmlAccessorType(XmlAccessType.FIELD)
public class Players {
    @XmlElement(name ="player")
    private ArrayList<Player> players;
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
