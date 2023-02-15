package e1;

public class Guionista extends Humano implements Extras {
    float horasTrabajadas;
    boolean guionOriginal;
    public Guionista(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas, boolean guionOriginal) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
        this.guionOriginal = guionOriginal;
    }

    @Override
    public float getSalario() {
        float salarioBase = 60;
        return salarioBase * this.horasTrabajadas;
    }
    public float getRoyalties(float recaudacion){
        return (float) (recaudacion * 0.05);
    }

    @Override
    public String extras() {
        if(guionOriginal){
            return " con extra por guion original";
        }
        else{
            return "";
        }
    }
}
