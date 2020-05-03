package fruitNinja.controllers;

import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.users.Leaderboard;
import fruitNinja.views.pages.LeaderboardView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// CONTROLLER THAT MANAGES THE VIEW IN WHICH THE LEADER BOARD IS DISPLAYED
public class LeaderboardController extends BaseController {

    private LeaderboardView leaderboardView;
    private Leaderboard leaderboard;
    List<Leaderboard> scores = new ArrayList<>();

    public LeaderboardController(LeaderboardView leaderboardView) {
        this.leaderboardView=leaderboardView;
        setEventHandlers();
    }

    // SETS THE SCORE LABEL AND SHOWS THE SCORE LEADER BOARD FOR THE SELECTED GAME MODE
    private void settingLabel(StrategyType strategyType){

        leaderboardView.getNames().setText("");
        leaderboardView.getScores().setText("");
        leaderboard = new Leaderboard(strategyType);
        scores = leaderboard.Sort();

        for(Leaderboard leaderboard:scores)
        {
            leaderboardView.getNames().setText(leaderboardView.getNames().getText()+"\n"+leaderboard.getUserName());
            leaderboardView.getScores().setText(leaderboardView.getScores().getText()+"\n"+leaderboard.getScore());
        }
    }

    // SHOWS THE SCORES FOR THE ARCADE MODE
    private void arcadeScores(){
      settingLabel(StrategyType.ARCADE);
    }

    // SHOWS THE SCORES FOR THE CLASSIC MODE
    private void classicScores(){
       settingLabel(StrategyType.CLASSIC);
    }

    // SHOWS THE SCORES FOR THE ZEN MODE
    private void zenScores(){
        settingLabel(StrategyType.ZEN);
    }

    // NAVIGATES BACK TO THE MAIN DASHBOARD PAGE
    private void back() {
        navigation.showMainDashboardPage((Stage) leaderboardView.getClassicButton().getScene().getWindow());
    }

    // SETS THE EVENT HANDLERS FOR THE VIEW BUTTONS
    private void setEventHandlers()
    {
        leaderboardView.addArcadeButtonListener(event -> arcadeScores());
        leaderboardView.addClassicButtonListener(event -> classicScores());
        leaderboardView.addZenButtonListener(event -> zenScores());
        leaderboardView.addBackButtonListener(event -> back());
    }
}
