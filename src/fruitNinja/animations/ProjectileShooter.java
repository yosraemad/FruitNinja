package fruitNinja.animations;

import fruitNinja.models.Difficulty;
import fruitNinja.models.entities.Sprite;
import javafx.geometry.Point2D;

import java.util.*;

public class ProjectileShooter {

    public ProjectileShooter(){

    }

    // SETS THE STARTING POINT OF THE THROWN PROJECTILE

    public void setStartingPoint(Sprite sprite) {
        Random random = new Random();

        // MAX RANGE RULE TO BE USED TO LIMIT FALLING OFF SIDES

        sprite.setXLocation(random.nextInt(1240 - 40) + 40);
        sprite.setYLocation(750);

        setAngle(sprite);

    }

    // MOVES THE PROJECTILE ON HIS PARABOLIC PATH DEPENDING ON THE DIFFICULTY

    public void moveProjectile(Sprite sprite, Projectile projectile, Difficulty difficulty)
    {
        ProjectileUtilities projectileUtilities = new ProjectileUtilities();
        double timeInc = projectileUtilities.setTimeBasedOnDifficulty(difficulty);
        double currentTime = projectile.getCurrentTime();
        projectile.setCurrentTime(currentTime + timeInc);

        Point2D currentVelocity = projectile.getCurrentVelocity(currentTime);
        Point2D currentPosition = projectile.getCurrentPosition(currentVelocity,currentTime);

        sprite.setXLocation(currentPosition.getX());
        sprite.setYLocation(currentPosition.getY());

        if(sprite.getYlocation() > 760){
            sprite.fellOff();
        }
    }

    // SETS THE ANGLE IN WHICH THE PROJECTILE WILL BE THROWN

    private void setAngle(Sprite sprite) {
        Random random = new Random();

        if(sprite.getXlocation() < (float) 1280/2){

            if(sprite.getXlocation() < (float) 1280/4){
                sprite.setAngleRad(Math.toRadians(random.nextInt(90 - 70) + 70));
            }
            else{
                sprite.setAngleRad(Math.toRadians(random.nextInt(90-85)+85));
            }

        }
        else{
            if(sprite.getXlocation() < (float) 1280/2 + (float) 1280/4){
                sprite.setAngleRad(Math.toRadians(random.nextInt(95 - 90) + 90));
            }
            else{
                sprite.setAngleRad(Math.toRadians(random.nextInt(110 - 90) + 90));
            }
        }


    }
}
