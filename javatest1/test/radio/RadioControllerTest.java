package radio;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by chronoes on 10/15/15.
 */
public class RadioControllerTest {
    private List<CarRadio> radios;

    @Before
    public void setUp() throws Exception {
        radios = new ArrayList<>();
        radios.add(RadioController.of("Dodge Viper", 87.0, false));
        radios.add(RadioController.of("Ford Sierra", 93.5, true));
        radios.add(RadioController.of("Bugatti", 105.1, false));
        radios.add(RadioController.of("Datsun", 90.0, true));
        radios.add(RadioController.of("Hummer", 89.9, false));
    }

    @Test
    public void testEmergencyState() throws Exception {
        printState();
        RadioController.emergency(radios);
        printState();
        RadioController.exitEmergency(radios);
        printState();
    }

    private void printState() {
        for (CarRadio radio : radios) {
            System.out.println(radio.toString());
            radio.newStation();
            if (radio instanceof ImprovedCarRadio) {
                ((ImprovedCarRadio) radio).setCurrentlyPlaying();
            }
        }
        System.out.println();
    }
}