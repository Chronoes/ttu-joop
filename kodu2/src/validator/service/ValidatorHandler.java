package validator.service;

/**
 * Created by Chronoes on 10.09.2015.
 */
public interface ValidatorHandler {
    boolean validationInQueue();
    ValidatorTicket nextValidation();
}
