package fruitNinja.models.entities.bombs;

public class BombFactory {
    public Bomb createBomb(String bombType){
        Bomb bomb;
        switch(bombType.toLowerCase()){
            case "fatal":
                bomb = new FatalBomb();
                break;
            case "dangerous":
                bomb = new DangerousBomb();
                break;
            default:
                bomb = null;
        }
        return bomb;
    }

    public Bomb createBomb(BombType BombType){
        Bomb bomb;
        return createBomb(BombType.toString());
    }
}
