package coffee;

import coffee.exceptions.GrinderNotCleanException;
import power.SolarPower;
import power.exceptions.LowPowerException;

import java.time.LocalTime;

/**
 * Created by chronoes on 10/1/15.
 */
public class CoffeeMachine {
    protected final int GRIND_LIMIT_PER_CLEAN = 3;
    private static final LocalTime ESPRESSO_TIME_START = LocalTime.of(5, 59);
    private static final LocalTime ESPRESSO_TIME_STOP = LocalTime.of(11, 1);

    protected double diameter = 1.0;
    protected int count = 0;
    protected int energySaveMinutes = 0;
    protected SolarPower solarPower;


    public static CoffeeMachine ofNow() {
        return ofTime(LocalTime.now());
    }

    public static CoffeeMachine ofTime(LocalTime currentTime) {
        if (currentTime.isAfter(ESPRESSO_TIME_START) && currentTime.isBefore(ESPRESSO_TIME_STOP)) {
            return new EspressoMachine();
        }
        return new CoffeeMachine();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public double grind() throws GrinderNotCleanException {
        exitEnergySaving();
        if (hasPower()) {
            count++;
            if (count % GRIND_LIMIT_PER_CLEAN == 0) {
                clean();
            }
            if (count >= GRIND_LIMIT_PER_CLEAN) {
                throw new GrinderNotCleanException("Grinder has not been cleaned yet.");
            }
        }
        return diameter;
    }

    private void clean() {
        count = 0;
    }

    public void saveEnergy(int minutes) {
        if (minutes < 1 || minutes > 60) {
            throw new IllegalArgumentException("Argument must be between 1-60 minutes.");
        }
        energySaveMinutes = minutes;
    }

    public int getEnergySaveStatus() {
        return energySaveMinutes;
    }

    public void exitEnergySaving() {
        energySaveMinutes = 0;
    }

    public void setSolarPower(SolarPower solarPower) {
        this.solarPower = solarPower;
    }

    public boolean hasPower() {
        try {
            return solarPower.hasPower();
        } catch (LowPowerException err) {
            return false;
        }
    }
}
