package fruitNinja.models.users;

import javax.xml.bind.annotation.*;

// PLAYER ENTITY THAT CONTAINS HIS DATA AND LEVEL
@XmlRootElement(name="player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    @XmlElement(name="username")
    private String username;
    @XmlElement(name="fullName")
    private String fullName;
    @XmlElement(name="password")
    private String password;
    @XmlElement(name="level")
    private int level;
    @XmlElement(name="experience")
    private int experience;
    @XmlTransient
    private int currentScore;


    public Player()
    {

    }

    public Player(String fullName, String username, String password)
    {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    // GETTERS AND SETTERS

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
