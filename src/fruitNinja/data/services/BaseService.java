package fruitNinja.data.services;

import java.io.File;

// CLASS WHICH CONTAINS THE MUTUAL FIELDS BETWEEN THE SERVICES AND THE NEEDED FILES TO BE ACCESSED
public abstract class BaseService<T> implements Service<T> {
    private File playersFile;
    private File urlsFile;
    private File scoresFile;

    public BaseService()
    {
        setFiles();
    }

    // SETS THE URLS OF THE NEEDED FILES
    private void setFiles()
    {
        playersFile = new File("src/fruitNinja/data/files/players.xml");
        urlsFile = new File("src/fruitNinja/data/files/url.xml");
        scoresFile = new File("src/fruitNinja/data/files/scores.xml");
    }

    // GETTERS FOR THE FILES

    public File getPlayersFile() {
        return playersFile;
    }
    public File getUrlsFile(){
        return urlsFile;
    }
    public File getScoresFile(){
        return scoresFile;
    }
}
