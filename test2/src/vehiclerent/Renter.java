package vehiclerent;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by chronoes on 12/10/15.
 */
public class Renter implements Runnable {
    private String name;
    private Predicate<Vehicle> isSuitable;

    public Renter(String name, Predicate<Vehicle> isSuitable) {
        this.name = name;
        this.isSuitable = isSuitable;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Optional<Vehicle> vehicle = RentingSystem.checkForVehicle();
            vehicle.ifPresent(rentable -> {
                if (isSuitable.test(rentable)) {
                    RentingSystem.rentVehicle();
                    System.out.println(name + " rented " + rentable.toString());
                }
            });
        }
    }
}
