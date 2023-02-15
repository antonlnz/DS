package e2;

import java.util.Comparator;

public class MyComparator implements Comparator<Warning> {

    @Override
    public int compare(Warning w1, Warning w2) {
        if(w1.getColor() == Color.NONE || w2.getColor()== Color.NONE)
            throw new IllegalArgumentException();
        if ((w1.getColor() == Color.RED && w2.getColor() == Color.RED) || (w1.getColor() == Color.ORANGE && w2.getColor() == Color.ORANGE)){
            return 0;
        } else if (w1.getColor() == Color.RED) {
            return 1;
        } else {
            return -1;
        }
    }

}
