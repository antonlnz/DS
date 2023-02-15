package e1;

public class Especialista extends Humano implements Extras{
    float horasTrabajadas;
    boolean escenaRiesgo;
    public Especialista(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas, boolean escenaRiesgo) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
        this.escenaRiesgo = escenaRiesgo;
    }

    @Override
    public float getSalario() {
        float salarioBase = 40;
        float extra = 1000;
        if (escenaRiesgo) {
            return (salarioBase * this.horasTrabajadas + extra);
        } else {
            return (salarioBase * this.horasTrabajadas);
        }
    }

    @Override
    public String extras() {
        if(escenaRiesgo) {
            return " con extra por escena de riesgo";
        }
        else{
            return "";
        }
    }
}
