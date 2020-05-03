package fruitNinja.models.users;

import fruitNinja.data.services.ScoreService;
import fruitNinja.models.modes.StrategyType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// CLASS THAT MANAGES THE SCORES OF THE PLAYERS
public class Leaderboard implements Comparable<Leaderboard> {
    private String score;
    private String userName;
    private StrategyType strategyType;


    public Leaderboard(StrategyType strategyType) {
        this.strategyType=strategyType;
    }

    @Override
    public int compareTo(Leaderboard leaderboard) {
        int compare=leaderboard.getScore().compareTo(score);
        if (compare==0)
            compare=leaderboard.getUserName().compareTo(userName);
        return compare;
    }


    // A FUNCTION THAT SORTS THE LEADERBOARD
     public List<Leaderboard> Sort(){
       ScoreService scoreService= new ScoreService();
       List<Score> scores=scoreService.readData();

       List<Leaderboard> leaderboards=new ArrayList<>();
       for(Score score : scores)
           leaderboards.add(new Leaderboard(score.scoreStrategy(strategyType), score.getUsername()));

       Collections.sort(leaderboards);

       for (Leaderboard leaderboard:leaderboards)
           System.out.println(leaderboard.getScore()+" "+leaderboard.getUserName());

       return leaderboards;
    }

    // GETTERS AND SETTERS

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Leaderboard(String score, String userName) {
        this.score = score;
        this.userName = userName;
    }
}
