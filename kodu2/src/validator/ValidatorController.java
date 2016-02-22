package validator;

import validator.service.ValidatorHandler;
import validator.service.ValidatorTicket;

/**
 * Created by Chronoes on 10.09.2015.
 */
public class ValidatorController {
    private ValidatorHandler handler;

    public ValidatorController() {
        handler = new ValidatorQueueHandler();
    }

    public void processTickets() {
        while (handler.validationInQueue()) {
            ValidatorTicket ticket = handler.nextValidation();
            if (ticket.isFreePassenger()) {
                System.out.printf("%d, %s (%s)\n", ticket.getBirthYear(), ticket.getLocation(), "jah");
            } else {
                System.out.printf("%d, %s (%s)\n", ticket.getBirthYear(), ticket.getLocation(), "ei");
            }
        }
    }
}
