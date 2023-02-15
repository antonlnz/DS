package e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealityProgramCircularTest {

    static RealityProgram RealityC = new RealityProgram(Recorrido.Circular, 3);
    @Test
    void TVRealityCTest() {
        RealityC.lista.add("Anton");
        RealityC.lista.add("Blanca");
        RealityC.lista.add("Carla");
        RealityC.lista.add("Diego");
        RealityC.lista.add("Elena");
        Assertions.assertEquals("Diego", RealityC.selectCandidates());
    }
}

