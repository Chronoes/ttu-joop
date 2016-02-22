package vehiclerent;

import java.math.BigDecimal;

/**
 * Created by chronoes on 12/10/15.
 */
public class WaterVehicle extends Vehicle {
    private String material;
    private boolean hasEngine;

    public WaterVehicle(BigDecimal price, int registrationDate, String maker, String material, boolean hasEngine) {
        super(price, registrationDate, maker);
        this.material = material;
        this.hasEngine = hasEngine;
    }

    public String getMaterial() {
        return material;
    }

    public boolean hasEngine() {
        return hasEngine;
    }

    @Override
    public String toString() {
        return String.format("Water Vehicle :: Registration year: %s, maker: %s, material: %s\nHas engine: %s, Price per day: %s\n", registrationYear, maker, material, hasEngine ? "yes" : "no", pricePerDay.toPlainString());
    }
}
