package travel;

/**
 * Created by chronoes on 11/18/15.
 */
public class Temperature {
    private double minimum;
    private double maximum;

    public Temperature(double min, double max) {
        minimum = min;
        maximum = max;
    }

    public double getMinimum() {
        return minimum;
    }

    public double getMaximum() {
        return maximum;
    }
}
