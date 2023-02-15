package e2;

import java.util.NoSuchElementException;

public class RealityProgram {
    Recorrido tipoDeRecorrido;
    static TVRealityList<String> lista;
    static int k;

    public RealityProgram(Recorrido tipoDeRecorrido, int k) {
        this.tipoDeRecorrido = tipoDeRecorrido;
        this.lista = new TVRealityList<String>(this.tipoDeRecorrido);
        this.k = k;
    }
    public RealityProgram(Recorrido tipoDeRecorrido, int min, int max) {
        this.tipoDeRecorrido = tipoDeRecorrido;
        this.lista = new TVRealityList<String>(this.tipoDeRecorrido);
        this.k = random_number(min,max);
    }

    public int random_number(int min, int max) {
        if (max > lista.size() - 1) {
            max = lista.size() - 1;
        }
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public String selectCandidates() {
        String winner;
        String aux;
        int index;
        if(lista.size() < 1)
            throw new NoSuchElementException();
        /* Del iterator tengo la funcion next para ir al siguiente */
        do {
            for (int i = 1; i < k; i++) {
                lista.iterator().next();
            }
            lista.iterator().remove();
        }while((lista.size()) > 1);

        winner = lista.get(0);
        System.out.println("The winner is: " + winner);
        return winner;
    }
}

