package fruitNinja.models.users;

// A SINGLETON CLASS FOR THE ONLY PLAYER OBJECT OF THE LOGGED USER
public class PlayerSingleton {

    private volatile static Player playerSingleton;

    private PlayerSingleton()
    {

    }

    // GETS INSTANCE OF THE PLAYER SINGLETON
    public static Player getInstance() {
        if (playerSingleton == null) {
            synchronized (PlayerSingleton.class) {
                if (playerSingleton == null)
                    playerSingleton = new Player();
            }
        }

        return playerSingleton;
    }

    // SETS THE PLAYER SINGLETON
    public static void setPlayerSingleton(Player player)
    {
        playerSingleton = player;
    }

}
