package vehiclerent;

import java.math.BigDecimal;

/**
 * Created by chronoes on 12/10/15.
 */
public class RoadVehicle extends Vehicle {
    private int mileage;

    public RoadVehicle(BigDecimal price, int registrationDate, String maker, int mileage) {
        super(price, registrationDate, maker);
        this.mileage = mileage;
    }


    @Override
    public String toString() {
        return String.format("Road Vehicle :: Registration year: %s, maker: %s, mileage: %s\nPrice per day: %s\n", registrationYear, maker, mileage, pricePerDay.toPlainString());
    }

    public int getMileage() {
        return mileage;
    }
}
