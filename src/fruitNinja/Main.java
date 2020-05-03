package fruitNinja;

import fruitNinja.views.guiUtils.Navigation;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main extends Application {

    private Navigation navigation = new Navigation();

    @Override
    public void start(Stage primaryStage) throws Exception{
        navigation.showStartPage(primaryStage);
    }
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Font font = Font.loadFont(Main.class.getResourceAsStream("/fruitNinja/views/fonts/go3v2.ttf"), 14);
        launch(args);
    }
}
