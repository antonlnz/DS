package e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealityProgramReboteTest {
    static RealityProgram RealityR = new RealityProgram(Recorrido.Rebote, 3);

    @Test
    void TVRealityRTest(){
        RealityR.lista.add("Antia");
        RealityR.lista.add("Bruno");
        RealityR.lista.add("Carlos");
        RealityR.lista.add("Daniela");
        RealityR.lista.add("Emilio");
        Assertions.assertEquals("Antia", RealityR.selectCandidates());
    }
}

