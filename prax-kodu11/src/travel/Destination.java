package travel;

import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;

/**
 * Created by chronoes on 11/18/15.
 */

public class Destination implements DestinationModel {
    private Name name;
    private Temperature temperature;

    public Destination(Name name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public double convertTempToCelsius() {
        return convertTempToCelsius(temperature.getMinimum(), temperature.getMaximum());
    }

    public double convertTempToFahrenheit() {
        return convertTempToFahrenheit(temperature.getMinimum(), temperature.getMaximum());
    }

    public static double convertTempToCelsius(double minimum, double maximum) {
        return (minimum + maximum) / 2 - 273.15;
    }

    public static double convertTempToFahrenheit(double minimum, double maximum) {
        return (minimum + maximum) / 2 * 9 / 5 - 459.67;
    }

    public void processName(Consumer<Name> formatter) {
        formatter.accept(name);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public double getKelvin() {
        return (temperature.getMinimum() + temperature.getMaximum()) / 2;
    }

    @Override
    public double getAvgWeather(DoubleBinaryOperator tempHandler) {
        return tempHandler.applyAsDouble(temperature.getMinimum(), temperature.getMaximum());
    }
}
