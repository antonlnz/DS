package e2;

public enum Color {
    NONE, ORANGE, RED ;

    @Override
    public String toString() {
        if(this == RED){
            return "ROJA";
        }
        else if (this == ORANGE){
            return "NARANJA";
        }
        else
            return " ERROR ";
    }
}