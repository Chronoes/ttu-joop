package power;

import power.exceptions.LowPowerException;

/**
 * Created by Chronoes on 05.10.2015.
 */
public class SolarPower {
    private int powerCycle = 0;

    public boolean hasPower() throws LowPowerException {
        powerCycle++;
        if (powerCycle % 10 == 0) {
            throw new LowPowerException("Not enough power to process.");
        }
        return powerCycle % 2 == 0;
    }
}
