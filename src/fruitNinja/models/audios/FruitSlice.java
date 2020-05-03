package fruitNinja.models.audios;


public class FruitSlice implements Command{
    private Audio audio;

    public FruitSlice(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute()  {
       audio.fruitSlice();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }

}
