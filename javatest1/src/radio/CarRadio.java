package radio;

/**
 * Created by chronoes on 10/15/15.
 */
public class CarRadio {
    protected String name;
    protected double baseFrequency;
    protected double frequency;
    protected boolean emergency;


    public CarRadio(String name, double baseFrequency) {
        this.name = name;
        this.baseFrequency = baseFrequency;
        this.frequency = baseFrequency;
    }

    public double getFrequency() {
        return frequency;
    }

    public double newStation() {
        if (isBelow(baseFrequency)) {
            frequency -= 1.1;
        } else {
            frequency += 1.0;
        }
        return frequency;
    }

    protected boolean isBelow(double freq) {
        return freq < 90.0;
    }

    @Override
    public String toString() {
        String output = String.format("CarRadio 1.0: %s@%.1fMHz", name, frequency);
        if (emergency) {
            output += "\nRadio cannot be played due to antenna issues";
        }
        return output;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
