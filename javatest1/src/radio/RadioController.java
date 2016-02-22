package radio;

import java.util.List;

/**
 * Created by chronoes on 10/15/15.
 */
public class RadioController {
    public static CarRadio of(String name, double frequency, boolean improved) {
        return improved ?
                new ImprovedCarRadio(name, frequency) :
                new CarRadio(name, frequency);
    }

    public static void emergency(List<CarRadio> radios) {
        for (CarRadio radio : radios) {
            radio.setEmergency(true);
        }
    }

    public static void exitEmergency(List<CarRadio> radios) {
        for (CarRadio radio : radios) {
            radio.setEmergency(false);
        }
    }
}
