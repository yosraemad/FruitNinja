package fruitNinja.models.audios;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public interface Command {
     void execute() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
     void unexecute();
}
