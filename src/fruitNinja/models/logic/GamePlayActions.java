package fruitNinja.models.logic;

import fruitNinja.animations.Projectile;
import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.entities.Sprite;
import fruitNinja.utils.events.MouseDraggedEvent;
import fruitNinja.utils.events.MouseReleaseEvent;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.HashMap;

// CONTAINS ACTIONS THAT HAPPEN DURING THE GAMEPLAY
public class GamePlayActions {
    public static AnimationTimer animationTimer;
    public static int isPaused = 0;

    private Canvas canvas;
    private ProjectileShooter projectileShooter;

    public GamePlayActions()
    {
        this.projectileShooter = new ProjectileShooter();
    }

    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }

    // THROW THE SPRITES IN THE CANVAS AND UPDATES THEIR MOVEMENT UNTIL THE LAST ONE FALLS
    public void throwSprites(ArrayList<Sprite> sprites, Difficulty difficulty)
    {
        HashMap<Sprite, Projectile> spriteProjectileHashMap = associateProjectiles(sprites, difficulty);

        MouseDraggedEvent mouseDraggedEvent = new MouseDraggedEvent(spriteProjectileHashMap);
        MouseReleaseEvent mouseReleaseEvent = new MouseReleaseEvent(mouseDraggedEvent);

        canvas.setOnMouseDragged(mouseDraggedEvent);
        canvas.setOnMouseReleased(mouseReleaseEvent);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean done = updateSpritesMovement(spriteProjectileHashMap, difficulty);
                if (!done) this.stop();
            }
        };

        if(isPaused == 0)
            animationTimer.start();
    }

    // ASSOCIATES EACH SPRITE TO A PROJECTILE OBJECT TO KEEP TRACK OF ITS MOVEMENT IN THE PARABOLIC PATH
    private HashMap<Sprite, Projectile> associateProjectiles(ArrayList<Sprite> sprites, Difficulty difficulty)
    {
        HashMap<Sprite, Projectile> projectileHashMap = new HashMap<>();

        for (Sprite sprite:sprites)
        {
            projectileShooter.setStartingPoint(sprite);

            Projectile projectile = new Projectile(new Point2D(sprite.getXlocation(),sprite.getYlocation()),
                    difficulty,sprite.getAngleRad());

            projectileHashMap.put(sprite, projectile);
        }

        return projectileHashMap;

    }

    // UPDATES THE SPRITE MOVEMENT IN THE GAME AND MOVES IT TO THE NEXT PLACE IT SHOULD BE AND REMOVES THE SPRITES THAT FELL OFF
    private boolean updateSpritesMovement(HashMap<Sprite, Projectile> spriteProjectileHashMap, Difficulty difficulty)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0 , 1280, 720);
        spriteProjectileHashMap.forEach((k,v) -> {
            projectileShooter.moveProjectile(k, v, difficulty);
        });

        spriteProjectileHashMap.entrySet().removeIf(entry -> entry.getKey().hasMovedOffScreen());

        spriteProjectileHashMap.forEach((k,v) -> {
            if (!k.hasMovedOffScreen()) k.render(gc);
        });

        return !spriteProjectileHashMap.isEmpty();
    }
}
