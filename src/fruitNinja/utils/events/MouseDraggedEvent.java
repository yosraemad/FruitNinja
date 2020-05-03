package fruitNinja.utils.events;

import fruitNinja.animations.Projectile;
import fruitNinja.models.entities.Sprite;
import fruitNinja.models.entities.fruits.special.DoubleScore;
import fruitNinja.models.entities.fruits.special.SpecialFruit;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.HashMap;

public class MouseDraggedEvent implements EventHandler<MouseEvent> {

    private HashMap<Sprite, Projectile> spritesMap;
    public MouseDraggedEvent(HashMap<Sprite, Projectile> spritesMap)
    {
        this.spritesMap = spritesMap;
    }

    private int comboCount = 0;
    private int doubleScoreCount=0;
    boolean on=false;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        spritesMap.forEach((k,v) -> {
            if (k.intersect(mouseX, mouseY) && !k.isSliced()) {
                k.slice();
                incComboCount();
                if (k instanceof DoubleScore) {
                    setOn(true);
                    PauseTransition delay = new PauseTransition(Duration.seconds(3));
                    delay.setOnFinished(event -> delaySetting());
                    delay.play();
                }
                if (on && !(k instanceof SpecialFruit)) {
                    ControlsUpdaterSingleton.getInstance().sliceDoubleScore();
                    if (comboCount>2)
                    doubleScoreCount+=comboCount;
                    else doubleScoreCount++;
                }

            }
        });


    }
    private void delaySetting(){
        setOn(false);
        if(getDoubleScoreCount()>=0)
        ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(getDoubleScoreCount());
        setDoubleScoreCount(0);
        //setComboCount(0);
    }


    public int getComboCount()
    {
        return comboCount;
    }

    public void setComboCount(int comboCount)
    {
        this.comboCount = comboCount;
    }

    public void incComboCount()
    {
        comboCount++;
    }

    public int getDoubleScoreCount() {
        return doubleScoreCount;
    }

    public void setDoubleScoreCount(int doubleScoreCount) {
        this.doubleScoreCount = doubleScoreCount;
    }


}
