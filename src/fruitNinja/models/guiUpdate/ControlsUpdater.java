package fruitNinja.models.guiUpdate;

public class ControlsUpdater {
    public EventManager eventManager;

    public ControlsUpdater()
    {
        eventManager = new EventManager();
    }

    public void sliceOrdinaryFruit(int amount)
    {
        eventManager.notify("sliceOrdinary", String.valueOf(amount));
    }
    public void updateTimer(String time) { eventManager.notify("updateTimer", String.valueOf(time));}
    public void sliceFatalBomb(){
        eventManager.notify("sliceFatal","");
    }
    public void sliceDangerousBomb(int amount){
        eventManager.notify("sliceDangerous",String.valueOf(amount));
    }
    public void comboSliced(int amount) { eventManager.notify("sliceCombo", String.valueOf(amount));}
    public void fruitFell(int lifeMinimizing) {
        if(eventManager.getListeners().containsKey("fruitFellUnsliced"))
            eventManager.notify("fruitFellUnsliced", String.valueOf(lifeMinimizing));
    }
    public void sliceDoubleScore(){eventManager.notify("sliceDoubleScore","1");}
}
