package vehiclerent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by chronoes on 12/10/15.
 */
public class RentingSystem {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public static synchronized void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public static synchronized void rentVehicle() {
        if (vehicles.size() > 0) {
            vehicles.remove(0);
        }
    }

    public static synchronized Optional<Vehicle> checkForVehicle() {
        return vehicles.size() > 0 ? Optional.of(vehicles.get(0)) : Optional.empty();
    }

    public static void main(String[] args) {
        Thread wvSeller = new Thread(new WaterVehicleSeller());
        Thread rvSeller = new Thread(new RoadVehicleSeller());

        Thread renter1 = new Thread(new Renter("Renter 1", vehicle -> vehicle.pricePerDay().compareTo(BigDecimal.valueOf(100)) == -1));
        Thread renter2 = new Thread(new Renter("Renter 2", vehicle -> vehicle instanceof WaterVehicle && ((WaterVehicle) vehicle).hasEngine()));
        Thread renter3 = new Thread(new Renter("Renter 3", vehicle -> vehicle.pricePerDay().compareTo(BigDecimal.valueOf(50)) == -1 && vehicle.getRegistrationYear() < 2010));

        wvSeller.start();
        rvSeller.start();
        renter1.start();
        renter2.start();
        renter3.start();

        try {
            wvSeller.join();
            rvSeller.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            renter1.interrupt();
            renter2.interrupt();
            renter3.interrupt();
        }
    }
}
