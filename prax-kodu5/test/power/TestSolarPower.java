package power;

import power.exceptions.LowPowerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chronoes on 05.10.2015.
 */
public class TestSolarPower {
    private SolarPower solarPower;
    
    @Before
    public void setUp() throws Exception {
        solarPower = new SolarPower();
    }

    @Test
    public void testHasPower() throws LowPowerException {
        assertFalse("First call: no power", solarPower.hasPower());
        assertTrue("Second call: has power", solarPower.hasPower());
        assertFalse("Third call: no power", solarPower.hasPower());
        assertTrue("Fourth call: has power", solarPower.hasPower());
    }

    @Test(expected = LowPowerException.class)
    public void testLowPower() throws LowPowerException {
        for (int i = 0; i < 10; i++) {
            solarPower.hasPower();
        }
    }
}
