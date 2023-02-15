package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject { // Sujeto (clase observada)
    public List<Observer> observers;

    public List<Observer> getObservers() {
        return observers;
    }

    /**
     * Attach an observer to the subject.
     * @param o: observer to be attached.
     */
    public void attach(Observer o) { observers.add(o); }

    /**
     * Detach an observer from the subject.
     * @param o: observer to detach
     */
    public void detach(Observer o) { observers.remove(o); }

    /**
     * Notify all observers about an event.
     */
    public void notifyObservers() {
        for (Observer o : observers)
            o.update(this);
    }

}