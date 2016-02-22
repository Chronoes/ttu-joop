package vehiclerent;

import java.math.BigDecimal;

/**
 * Created by chronoes on 12/10/15.
 */
public class RoadVehicleSeller extends VehicleSeller {
    @Override
    protected Vehicle getVehicle(BigDecimal pricePerDay, int registrationYear, String maker) {
        return new RoadVehicle(pricePerDay, registrationYear, maker, randomInt(30000, 500000));
    }
}
