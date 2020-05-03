package fruitNinja.models.users;

import fruitNinja.models.modes.StrategyType;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="score")
@XmlAccessorType(XmlAccessType.FIELD)
public class Score {
    @XmlTransient
    StrategyType strategyType;
    @XmlElement(name="username")
    private String username;
    @XmlTransient
    private String score;
    @XmlElement(name="zenScore")
    private String zenScore="0";
    @XmlElement(name = "classicScore")
    private String classicScore="0";
    @XmlElement(name = "arcadeScore")
    private String arcadeScore="0";

    @XmlTransient
    private String scoreType;

    public Score() {
    }

    public Score(StrategyType strategyType, String score) {
        this.strategyType = strategyType;
        this.score=score;
        this.username=PlayerSingleton.getInstance().getUsername();
        chooseStrategy(strategyType,this.score);
    }

    // CHOOSES THE STRATEGY OF THE SCORE
    public void chooseStrategy(StrategyType strategyType,String score) {
        switch (strategyType){
            case ZEN:
                zenScore=score;
                break;
            case ARCADE:
                arcadeScore=score;
                break;
            case CLASSIC:
                classicScore=score;
                break;
        }
    }

    public void scoreUponStrategy(String score,StrategyType strategyType) {
        switch (strategyType){
            case ZEN:
                setZenScore(score);
                break;
            case ARCADE:
                setArcadeScore(score);
                break;
            case CLASSIC:
               setClassicScore(score);
                break;
        }
    }

    // RETURN THE SCORE BY STRATEGY
    public String scoreStrategy(StrategyType strategyType){

        switch (strategyType) {
            case ZEN:
                scoreType=getZenScore();
                break;
            case ARCADE:
                scoreType=getArcadeScore();
                break;
            case CLASSIC:
                scoreType=getClassicScore();
                break;
        }

        return scoreType;
    }

    // GETTERS AND SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getZenScore() {
        return zenScore;
    }

    public void setZenScore(String zenScore) {
        this.zenScore = zenScore;
    }

    public String getClassicScore() {
        return classicScore;
    }

    public void setClassicScore(String classicScore) {
        this.classicScore = classicScore;
    }

    public String getArcadeScore() {
        return arcadeScore;
    }

    public void setArcadeScore(String arcadeScore) {
        this.arcadeScore = arcadeScore;
    }

}

