package travel;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 11/18/15.
 */
public class DestinationTest {
    private Destination destEarth;
    private Destination destMars;
    private Destination destJupiter;

    @Before
    public void setUp() throws Exception {
        destEarth = new Destination(new Name("Earth", "Maa", "Republic of Estonia", "Inner Solar System Planets"), new Temperature(185.15, 331.15));
        destMars = new Destination(new Name("Mars", "Mars", "Republic of Estonia", "Inner Solar System Planets"), new Temperature(186.15, 268.15));
        destJupiter = new Destination(new Name("Jupiter", "Jupiter", "Federal Republic of Nigeria", "Outer Solar System Planets"), new Temperature(288.0, 333.0));
    }

    @Test
    public void testConvertTempToCelsius() throws Exception {
        assertEquals(-15.0, destEarth.convertTempToCelsius(), 0.01);
        assertEquals(-46.0, destMars.convertTempToCelsius(), 0.01);
        assertEquals(37.35, destJupiter.convertTempToCelsius(), 0.01);
        System.out.println("Celsius:");
        System.out.println(destEarth.convertTempToCelsius());
        System.out.println(destMars.convertTempToCelsius());
        System.out.println(destJupiter.convertTempToCelsius());
    }


    @Test
    public void testConvertTempToFahrenheit() throws Exception {
        assertEquals(5.0, destEarth.convertTempToFahrenheit(), 0.01);
        assertEquals(-50.8, destMars.convertTempToFahrenheit(), 0.01);
        assertEquals(99.23, destJupiter.convertTempToFahrenheit(), 0.01);
        System.out.println("Fahrenheit:");
        System.out.println(destEarth.convertTempToFahrenheit());
        System.out.println(destMars.convertTempToFahrenheit());
        System.out.println(destJupiter.convertTempToFahrenheit());
    }

    @Test
    public void testGetAvgWeatherCelsius() throws Exception {
        assertEquals(-15.0, destEarth.getAvgWeather(Destination::convertTempToCelsius), 0.01);
        assertEquals(-46.0, destMars.getAvgWeather(Destination::convertTempToCelsius), 0.01);
        assertEquals(37.35, destJupiter.getAvgWeather(Destination::convertTempToCelsius), 0.01);
    }

    @Test
    public void testGetAvgWeatherFahrenheit() throws Exception {
        assertEquals(5.0, destEarth.getAvgWeather(Destination::convertTempToFahrenheit), 0.01);
        assertEquals(-50.8, destMars.getAvgWeather(Destination::convertTempToFahrenheit), 0.01);
        assertEquals(99.23, destJupiter.getAvgWeather(Destination::convertTempToFahrenheit), 0.01);
    }
}