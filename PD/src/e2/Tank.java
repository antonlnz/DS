package e2;

import java.util.ArrayList;
import java.util.Objects;

public class Tank extends Subject { // Sujeto Concreto que se observa
    private int level;
    private String name;
    private String ubication;

    public Tank(int level, String name, String ubication) { // Por si se añaden uno a uno los elementos de las listas
        this.level = level;
        this.name = name;
        this.observers = new ArrayList<>();
        this.ubication = ubication;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyObservers();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    @Override
    public void attach(Observer o) {
        if (o instanceof Sensor)
            super.attach(o);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void detach(Observer o) {
        super.detach(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tank tank = (Tank) o;
        return level == tank.level && name.equals(tank.name);
    }

}