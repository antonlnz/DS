package e2;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.Objects;

public class Warning extends Subject implements Observer {
    private float orangeMin, orangeMax;

    private float redMin, redMax;

    private Color color;

    private Sensor sensor; // Se le asocia un unico sensor

    private Date date;

    private Hour hour;

    public Warning(float orangeMin, float orangeMax, float redMin, float redMax) {
        this.observers = new ArrayList<>();
        if (redMin < orangeMin) {
           setOrangeMin(orangeMin);
            setRedMin(redMin);
        } else {
            throw new IllegalArgumentException();
        }
        if(redMax > orangeMax) {
            setOrangeMax(orangeMax);
            setRedMax(redMax);
        } else {
            throw new IllegalArgumentException();
        }
        setColor(Color.NONE);

    }

    public void setOrangeMin(float orangeMin) {
        this.orangeMin = orangeMin;
    }

    public float getOrangeMax() {
        return orangeMax;
    }

    public void setOrangeMax(float orangeMax) {
        this.orangeMax = orangeMax;
    }

    public float getRedMin() {
        return redMin;
    }

    public void setRedMin(float redMin) {
        this.redMin = redMin;
    }

    public float getRedMax() {
        return redMax;
    }

    public void setRedMax(float redMax) {
        this.redMax = redMax;
    }

    @Override
    public void attach(Observer o) {
        //SOLO SE LE PUEDE  UN DISPOSITIVO DE CONTROL
        if (o instanceof Device) {
            if (observers.size() == 0)
                observers.add(o);
            else {
                int i;
                for (i = 0; i < observers.size(); i++) {
                    if (observers.get(i) instanceof Device)
                        throw new IllegalArgumentException();
                }
                if (i == observers.size())
                    observers.add(o);
            }
        }
        else if(o instanceof Personal){//o instance of Personal
            observers.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        super.detach(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyObservers();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public Sensor getSensor() {
        return sensor;
    }

    @Override
    public void update(Subject s) {
        Sensor sensor = (Sensor) s;
        this.sensor = sensor;
        if (sensor.getParam() < redMin || sensor.getParam() > redMax) {
            setColor(Color.RED);
            setHour(new Hour());
            setDate(new Date());
            this.notifyObservers();
        } else if (sensor.getParam() < orangeMin || sensor.getParam() > orangeMax) {
            setColor(Color.ORANGE);
            setHour(new Hour());
            setDate(new Date());
            this.notifyObservers();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warning warning = (Warning) o;
        return Float.compare(warning.orangeMin, orangeMin) == 0 &&
                Float.compare(warning.orangeMax, orangeMax) == 0 &&
                Float.compare(warning.redMin, redMin) == 0 &&
                Float.compare(warning.redMax, redMax) == 0 &&
                color == warning.color &&
                this.observers == ((Warning) o).observers;
    }

}