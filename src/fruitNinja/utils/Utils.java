package fruitNinja.utils;

import fruitNinja.models.Difficulty;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import javafx.scene.control.Label;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Utils {

    public int generateRandomFruitNumBasedOnDifficulty(Difficulty difficulty)
    {
        Random random = new Random();
        int min = 3;
        switch (difficulty)
        {
            case MEDIUM: min += random.nextInt(1) + 1;  break; // 4 OR 5
            case HARD: min += random.nextInt(1) + 2; break; // 5 OR 6
        }
        return min;
    }

    public int generateRandomBombNumBasedOnDifficulty(Difficulty difficulty)
    {
        int min = 0;
        switch (difficulty)
        {
            case EASY: min = (int)((Math.random()*(1-0+1))); break; // 0 OR 1
            case MEDIUM: min = (int)((Math.random()*(2-1+1))+1);  break; // 1 OR 2
            case HARD: min = (int)((Math.random()*(2-1+1))+1); break; // 1 OR 2
        }

        return min;
    }

    public boolean generateSpecialFruit()
    {
        int n = (int)((Math.random()*(1-1+1))+1); //random num from 1 to 6
        if (n==1)
            return true;
        return false;
    }

    public Difficulty getDifficultyByWaveNumber(int wave)
    {
        if (wave > 10) return Difficulty.HARD;
        else if (wave > 5) return Difficulty.MEDIUM;
        else return Difficulty.EASY;
    }

    public <T extends Enum<?>> T randomValueFromEnum(Class<T> en)
    {
        Random random = new Random();
        int n = random.nextInt(en.getEnumConstants().length);
        return en.getEnumConstants()[n];
    }

    public int calculateExperiencePoints(int level)
    {
        return (int) Math.pow(2, level + 7);
    }

    public void showLabelForCertainTime(Label label, long time)
    {
        label.setVisible(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
                timer.cancel();
                timer.purge();
            }
        }, time);
    }
    int counter = 0;


    }
