package fruitNinja.models.audios;


public class SpecialSlice implements Command {
    private Audio audio;

    public SpecialSlice(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.specialSlice();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
