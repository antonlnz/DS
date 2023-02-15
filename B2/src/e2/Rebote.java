package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Rebote<String> implements Iterator<String> {

    private List<String> source = new ArrayList<>();
    private int index;
    private boolean sentidoContrario;

    public Rebote(List<String> source) {
        this.source = source;
        this.index = 0;
        this.sentidoContrario = false;
    }

    @Override
    public boolean hasNext() {
        return this.source.size() > 1;
    }

    @Override
    public String next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        if(!sentidoContrario){
            if(index == source.size()-2){
                sentidoContrario = true;
            }
            index = index +1;
            return source.get(index);
        }
        else{
            if(index == 1){
                sentidoContrario = false;
            }
                index = index -1;
            return source.get(index);
        }
    }

    @Override
    public void remove() {
        source.remove(index);
        if(!sentidoContrario){
            index = index-1;
        }
    }
}
