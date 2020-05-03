package fruitNinja.utils;

import fruitNinja.models.logic.GamePlayActions;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.guiUpdate.ControlsUpdater;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.views.guiUtils.Navigation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CustomTimer {
    private int startingTime;
    private Timeline timeline;
    private IntegerProperty timeSeconds;
    private ControlsUpdater controlsUpdater;
    private boolean over = false;
    private Stage stage;
    private StrategyType strategyType;

    public CustomTimer(int startingTime, Stage stage, StrategyType strategyType)
    {
        this.stage = stage;
        this.strategyType = strategyType;
        this.startingTime = startingTime;
        this.controlsUpdater = ControlsUpdaterSingleton.getInstance();
    }

    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }

    public void initCustomTimer()
    {
        startTimer();
        updateTimer();
    }


    private void startTimer() {
        timeSeconds = new SimpleIntegerProperty(startingTime);
        controlsUpdater.updateTimer(String.valueOf(startingTime));
    }

    public void updateTime() {
        controlsUpdater.updateTimer(String.valueOf(timeSeconds.getValue()));
        int seconds = timeSeconds.get();
        if(GamePlayActions.isPaused ==1){
            timeline.pause();
        }
        if (timeSeconds.get() <= 0) {
            over= true;
            GamePlayActions.isPaused = -1;
            Navigation navigation = new Navigation();
            navigation.showGameOverPage(stage,strategyType);
            timeline.stop();
        }
        timeSeconds.set(seconds - 1);
    }

    private void updateTimer(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt->updateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeSeconds.set(startingTime);
        timeline.play();
    }
}