package e1;

public class Director extends Humano implements Extras {
    float horasTrabajadas;
    int anosExperiencia;

    public Director(String nombre, String apellido, String dni, int tlf, String nacionalidad, float horasTrabajadas, int anosExperiencia) {
        super(nombre, apellido, dni, tlf, nacionalidad);
        this.horasTrabajadas = horasTrabajadas;
        this.anosExperiencia = anosExperiencia;
    }
    @Override
    public float getSalario() {
        float salarioBase = 100;
        float extraExp = 1000;

        return (salarioBase * this.horasTrabajadas + extraExp * anosExperiencia);
    }
    @Override
    public float getRoyalties(float recaudacion){
        return (float) (recaudacion * 0.05);
    }

    @Override
    public String extras() {
        if(anosExperiencia > 0){
            return " con extra por " + (this.anosExperiencia) + " años de experiencia";
        }
        else{
            return "";
        }
    }
}
