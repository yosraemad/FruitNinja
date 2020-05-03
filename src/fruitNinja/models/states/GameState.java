package fruitNinja.models.states;

import fruitNinja.utils.pause.PauseLogic;

// CLASS FOR INVOKING THE METHODS OF THE STATE
public class GameState {
    private PauseLogic pauseLogic = new PauseLogic();
    private State state;

    public GameState(){
        this.state = new PlayingState(this);
    }


    public void changeState(State state){
        this.state = state;
    }


    public void clickPause(){
        state.clickPause();
    }
    public void clickPlay(){
        state.clickPlay();
    }


    public void pausePlaying(){
        pauseLogic.pauseAnimationTimer();
    }
    public void continuePlaying(){
        pauseLogic.resumeAnimationTimer();
    }
}
