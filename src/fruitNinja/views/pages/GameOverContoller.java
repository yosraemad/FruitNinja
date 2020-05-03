package fruitNinja.views.pages;

import fruitNinja.models.audios.AudioController;
import javafx.fxml.Initializable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dc user on 29/04/2020.
 */
public class GameOverContoller implements Initializable {
    AudioController audioController=new AudioController();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        audioController.start("GameOver");
    }
}
