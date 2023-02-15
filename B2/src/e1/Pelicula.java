package e1;

import java.util.ArrayList;

public class Pelicula {
    String titulo;
    float recaudacion;
    ArrayList<Humano> personal_list = new ArrayList<>();

    public Pelicula(String titulo, float recaudacion) {
        this.titulo = titulo;
        this.recaudacion = recaudacion;
    }

    public void insertWorker(Humano h){
        personal_list.add(personal_list.size(), h);
    }

    private String extras (Humano worker) {

        if (worker instanceof Extras) {
            return ((Extras) worker).extras();
        }
        else{
            return "";
        }
    }


    public float printSalaries(){
        Humano worker;
        String aux;
        float totalSalaries = 0;
        for (Humano humano : personal_list) {
            worker = humano;
            aux = worker.getClass().descriptorString();
            System.out.println(worker.nombre + ' ' + worker.apellido + '\t' + "(" +
            aux.substring(4, aux.length() -1) +  extras(worker) + ")" + '\t' + worker.getSalario());
            totalSalaries = totalSalaries + worker.getSalario();
        }
        System.out.println("El gasto en salarios de la pelicula " + this.titulo + " es " + totalSalaries +" euros.");
    return totalSalaries;
    }
    public float printRoyalties(){
        Humano worker;
        float totalRoyalties = 0;
        for(Humano humano : personal_list){
            worker = humano;
            if (worker.getRoyalties(this.recaudacion) > 0){
                System.out.println( worker.nombre + ' ' + worker.apellido + '\t' + '(' +
                        worker.getClass().descriptorString().substring(4, worker.getClass().descriptorString().length() -1) + ')' + '\t' +  worker.getRoyalties(this.recaudacion));
                totalRoyalties = totalRoyalties + worker.getRoyalties(this.recaudacion);
            }
        }
        /* Para ponerlo con solo 2 decimales: */
        totalRoyalties = (float) (Math.round(totalRoyalties * 100) / 100);
        System.out.println("Total de royalties: " + totalRoyalties + " euros.");
        return totalRoyalties;
    }
}
