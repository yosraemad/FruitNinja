package fruitNinja.models.audios;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class Invoker  {
    private Command command;

    public void setCommand(Command command){this.command=command;}

    public void play() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        command.execute();
    }

    public void stop(){
        command.unexecute();
    }
}
