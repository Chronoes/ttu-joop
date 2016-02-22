package validator;

import validator.service.ValidatorTicket;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chronoes on 10.09.2015.
 */
public class BusTicket extends ValidatorTicket {
    private List<String> freePassengerLocations = Arrays.asList("Hiiumaa", "Kunda");

    public BusTicket(int birthYear, String location) {
        addToTicket(birthYear, location);
    }

    public boolean isFreePassenger() {
        int age = Year.now().minusYears((long)getBirthYear()).getValue();
        return freePassengerLocations.contains(getLocation()) || age < 8 || age >= 65;
    }
}
