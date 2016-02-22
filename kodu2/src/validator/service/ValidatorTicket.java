package validator.service;

/**
 * Created by Chronoes on 10.09.2015.
 */
public abstract class ValidatorTicket implements ValidatorService {
    private int birthYear;
    private String location;

    @Override
    public void addToTicket(int birthYear, String location) {
        this.birthYear = birthYear;
        this.location = location;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public abstract boolean isFreePassenger();
}
