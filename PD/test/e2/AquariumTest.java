package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {
    // Creamos los tanques
    Tank tropicalFish = new Tank(150, "Tropical Fishes", "Interior");

    // Creamos los sensores
    Sensor o2Sensor = new Sensor("O2 Sensor");
    Sensor temperatureSensor = new Sensor("Temperature Sensor");

    // Creamos los warnings
    Warning temperature_warning = new Warning(10, 20 ,0, 30);

    Personal maintenance = new Personal();

    @Test
    void aquariumTest() {
        tropicalFish.attach(o2Sensor);
        tropicalFish.detach(o2Sensor);

        tropicalFish.attach(temperatureSensor);
        assertEquals(temperatureSensor, tropicalFish.getObservers().get(0));
        temperatureSensor.attach(temperature_warning);
        assertEquals(temperature_warning, temperatureSensor.getObservers().get(0));

        temperature_warning.attach(maintenance);

        tropicalFish.setLevel(15);
        assertEquals(15, tropicalFish.getLevel());

        tropicalFish.setLevel(5);
        assertEquals(Color.ORANGE, temperature_warning.getColor());
        maintenance.informe(tropicalFish);

        tropicalFish.setLevel(35);
        assertEquals(Color.RED, temperature_warning.getColor());
        maintenance.informe(tropicalFish);

    }

}