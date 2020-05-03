package fruitNinja.models.audios;

public class BombSlice implements Command {
    private Audio audio;

    public BombSlice(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.bombSlice();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
