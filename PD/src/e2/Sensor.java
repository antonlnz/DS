package e2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Sensor extends Subject implements Observer { // Tiene que saber a que alertas está asociado ???
    public float paramValue;
    public String name;

    public Sensor(float param_value, String name) {
        this.paramValue = param_value;
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public Sensor(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public float getParam() {
        return paramValue;
    }
    public String getName() {
        return name;
    }

    public void setParam_value(float param_value) {
        this.paramValue = param_value;
    }

    @Override
    public void attach(Observer o) {
        if(o instanceof Warning){
            observers.add(o);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void detach(Observer o) {
        super.detach(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers)
            o.update(this);
    }

    @Override
    public void update(Subject s) {
        Tank aux = (Tank) s;
        setParam_value(aux.getLevel());
        this.notifyObservers();
    }

}
