package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PeliculaTest {
    private static final Pelicula Avatar = new Pelicula("Avatar", (float) 292381.885200); // (Recaudacion Mundial / 1.000.000)

    @BeforeAll
    static void createWorkers(){
        Director JC_d = new Director("James", "Cameron", "11111111A", 999999999, "Canada",500, 15);
        Guionista JC_g = new Guionista("James", "Cameron", "11111111A", 999999999, "Canada",100, true);
        Productor JL  = new Productor("Jon", "Landau", "22222222A", 88888888, "EEUU", 150);
        Musico JH = new Musico("James", "Horner", "33333333A", 77777777, "EEUU", 50);
        Interprete Neytiri = new Interprete("Zoe", "Saldana","44444444A", 66666666, "Rep. Dominicana", 300, rol.secundario );
        Interprete JSully = new Interprete("Sam", "Worthington", "33333333A", 55555555, "UK", 400, rol.principal);
        Especialista JSully_e = new Especialista("Jose", "Rodriguez", "00123456C", 644444444, "Espana", 100, true);
        Doblador JSully_d = new Doblador("Daniel", "Garcia", "12345600D", 655555555, "Espana", 50);
        Avatar.insertWorker(JC_d);
        Avatar.insertWorker(JC_g);
        Avatar.insertWorker(JL);
        Avatar.insertWorker(JH);
        Avatar.insertWorker(Neytiri);
        Avatar.insertWorker(JSully);
        Avatar.insertWorker(JSully_e);
        Avatar.insertWorker(JSully_d);
    }

    @Test
    void printSalariesTest() {
        Assertions.assertEquals((float) 393500.0, Avatar.printSalaries());
    }
    @Test
    void printRoyaltiesTest(){
        Assertions.assertEquals(46781.0, Avatar.printRoyalties());
    }
}