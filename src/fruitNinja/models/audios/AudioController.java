package fruitNinja.models.audios;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class AudioController {
    private String type;
    private Audio audio = new Audio();
    private Invoker invoker = new Invoker();
    private Command command;

    public AudioController() {

    }

    // COMMAND FACTORY THAT INVOKES THE COMMAND DEPENDING ON THE STRING
    public Command start(String type) {
        switch (type.toLowerCase()) {
            case "bomb" :
                command = new BombSlice(audio);
                break;
            case "fruit" :
                command = new FruitSlice(audio);
                break;
            case "special" :
                command = new SpecialSlice(audio);
                break;
            case "start" :
                command = new StartGame(audio);
                break;
            case "gameover" :
                command = new GameOver(audio);
                break;
        }

        invoker.setCommand(command);

        try {
            invoker.play();

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

        return command;
    }

    public void stop(){
        invoker.stop();
    }
}
