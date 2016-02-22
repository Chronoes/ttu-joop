package validator.service;

/**
 * Created by Chronoes on 10.09.2015.
 */
public interface ValidatorService {
    void addToTicket(int birthYear, String location);
    boolean isFreePassenger();
}
