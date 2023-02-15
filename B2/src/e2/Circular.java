package e2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Circular<String> implements Iterator<String> {

    private List<String> source = null;
    private int index;

    public Circular(List<String> source) {
        this.source = source;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index <= this.source.size() - 1;
    }

    @Override
    public String next() {
        /*CASO ESPECIAL*/
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.index == this.source.size()-1) {
            this.index = 0;
        } else {
            this.index = index+1;
        }
        return this.source.get(this.index);
    }
    @Override
    public void remove() {
        source.remove(index);
        index=index-1;
    }
}
