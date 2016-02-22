package coffee;

import coffee.exceptions.GrinderNotCleanException;
import org.junit.Before;
import org.junit.Test;
import power.SolarPower;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 10/1/15.
 */
public class TestEspressoMachine {
    private static final double EPS = 1e-5;
    private EspressoMachine espressoMachine;

    @Before
    public void setUp() throws Exception {
        espressoMachine = new EspressoMachine();
        SolarPower power = new SolarPower();
        espressoMachine.setSolarPower(power);
    }

    @Test
    public void testGrinding() throws GrinderNotCleanException {
        assertEquals(0.3, espressoMachine.grind(), EPS);
    }
}
