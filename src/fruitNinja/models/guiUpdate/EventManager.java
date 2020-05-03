package fruitNinja.models.guiUpdate;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    private HashMap<String, ArrayList<EventListener>> listeners = new HashMap<>();


    public void subscribe(String eventType, EventListener listener) {

        if (!listeners.containsKey(eventType)) {
            listeners.put(eventType, new ArrayList<>());
        }

        ArrayList<EventListener> _listeners = listeners.get(eventType);
        _listeners.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        ArrayList<EventListener> _listeners = listeners.get(eventType);
        _listeners.remove(listener);
    }

    public void notify(String eventType, String data) {
        ArrayList<EventListener> _listeners = listeners.get(eventType);
        for (EventListener listener : _listeners) {
            listener.update(eventType, data);
        }
    }

    public HashMap<String, ArrayList<EventListener>> getListeners() {
        return listeners;
    }
}
