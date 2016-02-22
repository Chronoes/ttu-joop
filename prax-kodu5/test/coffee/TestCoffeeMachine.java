package coffee;

import coffee.exceptions.GrinderNotCleanException;
import org.junit.Before;
import org.junit.Test;
import power.SolarPower;
import power.exceptions.LowPowerException;

import static org.mockito.Mockito.*;

import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 10/1/15.
 */
public class TestCoffeeMachine {
    private static final double EPS = 1e-5;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() throws Exception, LowPowerException {
        coffeeMachine = new CoffeeMachine();
        SolarPower power = mock(SolarPower.class);
        when(power.hasPower()).thenReturn(true);
        coffeeMachine.setSolarPower(power);
    }

    @Test
    public void testGrinding() throws GrinderNotCleanException {
        assertEquals(1.0, coffeeMachine.grind(), EPS);
    }

    @Test
    public void testCountIncrease() throws GrinderNotCleanException {
        assertEquals(0, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(1, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(2, coffeeMachine.getCount());
    }

    @Test
    public void testCleaningProcess() throws GrinderNotCleanException {
        coffeeMachine.grind();
        coffeeMachine.grind();
        assertEquals(2, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(0, coffeeMachine.getCount());
    }

    @Test(expected = GrinderNotCleanException.class)
    public void testUncleanGrinder() throws GrinderNotCleanException {
        coffeeMachine.setCount(3);
        coffeeMachine.grind();
    }

    @Test
    public void testEnergySaving() throws Exception {
        coffeeMachine.saveEnergy(54);
        assertTrue(coffeeMachine.getEnergySaveStatus() >= 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testName() throws Exception {
        coffeeMachine.saveEnergy(68);
        coffeeMachine.saveEnergy(-3);
    }

    @Test
    public void testExitEnergySaving() throws GrinderNotCleanException {
        coffeeMachine.saveEnergy(54);
        coffeeMachine.exitEnergySaving();
        assertTrue(coffeeMachine.getEnergySaveStatus() == 0);

        coffeeMachine.saveEnergy(54);
        coffeeMachine.grind();
        assertTrue(coffeeMachine.getEnergySaveStatus() == 0);
    }

    @Test
    public void testFactoryOfTime() {
        CoffeeMachine coffeeFactory = CoffeeMachine.ofTime(LocalTime.of(15, 50));
        assertTrue(coffeeFactory instanceof CoffeeMachine);

        coffeeFactory = CoffeeMachine.ofTime(LocalTime.of(5, 59));
        assertTrue(coffeeFactory instanceof CoffeeMachine);

        coffeeFactory = CoffeeMachine.ofTime(LocalTime.of(6, 0));
        assertTrue(coffeeFactory instanceof EspressoMachine);

        coffeeFactory = CoffeeMachine.ofTime(LocalTime.of(11, 0));
        assertTrue(coffeeFactory instanceof EspressoMachine);
    }

    @Test
    public void testHasPower() throws Exception, GrinderNotCleanException {
        SolarPower power = new SolarPower();
        coffeeMachine.setSolarPower(power);
        assertEquals(0, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(0, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(1, coffeeMachine.getCount());
        coffeeMachine.grind();
        assertEquals(1, coffeeMachine.getCount());
    }
}
