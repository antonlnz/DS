package e1;

public class Productor extends Humano{
    float horasTrabajadas;
    public Productor(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public float getSalario() {
        float salarioBase = 90;
        return salarioBase * this.horasTrabajadas;
    }
    @Override
    public float getRoyalties(float recaudacion){
        return (float) (recaudacion * 0.02);
    }
}
