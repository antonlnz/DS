package e1;

public class Doblador extends Humano {
    float horasTrabajadas;
    public Doblador(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public float getSalario() {
        float salarioBase = 20;
        return (salarioBase * this.horasTrabajadas);
    }
}
