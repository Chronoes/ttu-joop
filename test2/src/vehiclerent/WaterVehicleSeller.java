package vehiclerent;

import java.math.BigDecimal;

/**
 * Created by chronoes on 12/10/15.
 */
public class WaterVehicleSeller extends VehicleSeller {
    @Override
    protected Vehicle getVehicle(BigDecimal pricePerDay, int registrationYear, String maker) {
        return new WaterVehicle(pricePerDay, registrationYear, maker, randomString(5), randomInt(1) == 0);
    }
}
