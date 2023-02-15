package e2;

import java.util.ArrayList;
import java.util.List;

public class Device implements Observer { // Un tanque puede tener devices y éstos pueden estar suscritos a una o varias alarmasç

    List<Warning> warningList;

    public Device(List<Warning> warningList) {
        this.warningList = warningList;
    }

    public Device(){
        this.warningList = new ArrayList<>();
    }

    public void addToWarningList(Warning warn) {
        try {
            warn.attach(this);
            // código que puede lanzar una excepción
        } catch (IllegalArgumentException exception) {
            // código para manejar la excepción Excepcion
            System.out.println("Cannot add the warning");
            return;
        }
        System.out.println("Warning added");
        warningList.add(warn);
    }

    public void removeFromWarningList(Warning warning) {
        this.warningList.remove(warning);
    }


    @Override
    public void update (Subject s) {
        Warning aux = (Warning) s;
        aux.notifyObservers();
    }

    //Como propuesta, device podria incrementar o decrecer el nivel del parametro que esta midiendo ...
    public void increment() {
        System.out.println("Incrementing...");
    }
    public void decrement() {
        System.out.println("Decrementing...");
    }

}