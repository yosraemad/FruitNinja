package fruitNinja.models.logic;


// CONTAINS THE PROPERTIES OF THE CURRENT GAME AND KEEPS TRACK OF ITS DATA
public class GameProperties {

    private int wave;
    private int life = 3;

    // GETTERS AND SETTERS

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
    public void incWave() {this.wave += 1;};

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
