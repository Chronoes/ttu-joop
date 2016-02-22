package vehiclerent;

import java.math.BigDecimal;

/**
 * Created by chronoes on 12/10/15.
 */
class Vehicle {
    protected BigDecimal pricePerDay;
    protected int registrationYear;
    protected String maker;

    public Vehicle(BigDecimal price, int registrationDate, String maker) {
        this.pricePerDay = price;
        this.registrationYear = registrationDate;
        this.maker = maker;
    }

    public BigDecimal pricePerDay() {
        return pricePerDay;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public String getMaker() {
        return maker;
    }
}
