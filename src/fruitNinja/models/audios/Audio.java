package fruitNinja.models.audios;

import javax.sound.sampled.*;
import java.io.*;

public class Audio {
    private Clip clip;

    // PLAYS SOUND OF FRUIT SLICE
    public void fruitSlice ()  {
      music("src/fruitNinja/views/audios/slice.wav");
    }

    // PLAYS SOUND OF SPECIAL FRUIT SLICE
    public void specialSlice() {
       music("src/fruitNinja/views/audios/Fruit Ninja s.wav");
    }

    // PLAYS SOUND OF GAME STARTING
    public void gameStart()  {
        music("src/fruitNinja/views/audios/fruit.wav");
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    // PLAYS SOUND OF GAME OVER
    public void gameOver() {
        music("src/fruitNinja/views/audios/Fruit Ninja gameover.wav");
    }

    // PLAYS SOUNDS OF BOMB SLICING
    public void bombSlice()  {
       music("src/fruitNinja/views/audios/Fruit Ninja bomb.wav");
    }

    // STOPS PLAYING THE MUSIC
    public void stop()
    {
        clip.stop();
    }

    // PLAYS MUSIC FROM FILE
    private void music(String fileName) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
