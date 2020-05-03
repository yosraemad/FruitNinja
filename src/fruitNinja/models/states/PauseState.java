package fruitNinja.models.states;

// A THE STATE IN WHICH APP IS PAUSED
public class PauseState extends State{
    public PauseState(GameState gameState) {
        super(gameState);
    }

    @Override
    public void clickPause() {

    }

    // SWITCH TO THE PLAY STATE
    @Override
    public void clickPlay() {
        gameState.continuePlaying();
        gameState.changeState(new PlayingState(gameState));
    }
}
