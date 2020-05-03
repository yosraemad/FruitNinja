package fruitNinja.models.states;


// A STATE IN WHICH THE APPLICATION IS ON TH RUN
public class PlayingState extends State{
    public PlayingState(GameState gameState) {
        super(gameState);
    }

    // SWITCH TO THE PAUSE STATE
    @Override
    public void clickPause() {
        gameState.pausePlaying();
        gameState.changeState(new PauseState(gameState));
    }

    @Override
    public void clickPlay() {

    }

}
