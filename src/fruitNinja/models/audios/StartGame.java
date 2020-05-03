package fruitNinja.models.audios;


public class StartGame implements Command {
    private Audio audio;

    public StartGame(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute()  {
        audio.gameStart();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
