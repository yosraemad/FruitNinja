package fruitNinja.utils.pause;

import fruitNinja.models.logic.GamePlayActions;

public class PauseLogic {

    public void pauseAnimationTimer(){
        GamePlayActions.animationTimer.stop();
    }
    public void resumeAnimationTimer(){
        GamePlayActions.animationTimer.start();
    }
}
