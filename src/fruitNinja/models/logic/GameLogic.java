package fruitNinja.models.logic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.entities.Sprite;
import fruitNinja.utils.Utils;

import java.util.ArrayList;

// CONTAINS THE SET OF STEPS THAT HAPPENS DURING THE GAME CYCLE
public class GameLogic {

    private StrategyType strategyType;

    private GamePlayService gamePlayService = new GamePlayService();
    private Utils utils = new Utils();

    public GameLogic(StrategyType strategyType)
    {
        this.strategyType = strategyType;
    }

    // THE FUNCTIONS THAT GETS REPEATED ALL OVER AND OVER AGAIN THAT CONTAINS THE LOGIC OF
    // INCREASING THE WAVE NUMBER AND GENERATING WAVE DEPENDING ON THE CURRENT DIFFICULTY
    // AND CALLING THE FUNCTION THAT MOVES THE SPRITES IN THE CANCAS
    public void startRound(GameProperties gameProperties, GamePlayActions gamePlayActions)
    {
        if( GamePlayActions.isPaused !=0)  return;
        int wave = gameProperties.getWave();
        Difficulty difficulty = utils.getDifficultyByWaveNumber(wave);
        ArrayList<Sprite> sprites = gamePlayService.generateWave(strategyType ,difficulty);
        gamePlayActions.throwSprites(sprites, difficulty);
        gameProperties.incWave();
    }
}
