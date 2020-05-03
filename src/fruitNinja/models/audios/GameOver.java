package fruitNinja.models.audios;


public class GameOver implements Command {
    private Audio audio;

    public GameOver(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.gameOver();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
