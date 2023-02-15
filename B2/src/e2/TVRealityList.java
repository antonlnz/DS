package e2;

import java.util.*;

public class TVRealityList<T> extends ArrayList<T>{
    Iterator<T> TipoDeRecorrido;
    Recorrido recorrido;

    public TVRealityList(Recorrido recorrido) {
        if(recorrido == Recorrido.Circular){
            this.TipoDeRecorrido = new Circular<>(this);
        }
        else if (recorrido == Recorrido.Rebote) {
            this.TipoDeRecorrido = new Rebote<>(this);
        }
        else {
            this.TipoDeRecorrido = new Circular<>(this);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.TipoDeRecorrido;
    }
}
