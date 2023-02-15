package e1;

public class Musico extends Humano {
    float horasTrabajadas;
    public Musico(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public float getSalario() {
        float salarioBase = 60;
        return salarioBase * this.horasTrabajadas;
    }
    @Override
    public float getRoyalties(float recaudacion){
        return (float) (recaudacion * 0.04);
    }
}
