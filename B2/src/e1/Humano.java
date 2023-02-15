package e1;

public abstract class Humano{
        float royalties;
        float salario;
        String nombre;
        String apellido;
        String dni;
        int tlf;
        String nacionalidad;

        public Humano(String nombre, String apellido, String dni, int tlf, String nacionalidad) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.dni = dni;
                this.tlf = tlf;
                this.salario = 0;
                this.royalties = 0;
                this.nacionalidad = nacionalidad;
        }
        public float getSalario() {
                return this.salario;
        }
        public float getRoyalties(float recaudacion){ return this.royalties;}
}