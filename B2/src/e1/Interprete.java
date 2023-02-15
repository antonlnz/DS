package e1;

enum rol {principal, secundario, extra}

public class Interprete extends Humano {
    rol rol;
    float horasTrabajadas;
    public Interprete(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas, rol r) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
        this.rol = r;
    }
    @Override
    public float getSalario() {
        float salarioBase = 200;
        if(this.rol == e1.rol.principal){
            return this.horasTrabajadas * salarioBase * 3;
        }
        return salarioBase * this.horasTrabajadas;
    }
}
