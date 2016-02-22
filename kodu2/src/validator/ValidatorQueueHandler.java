package validator;

import validator.service.ValidatorHandler;
import validator.service.ValidatorTicket;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Chronoes on 10.09.2015.
 */
public class ValidatorQueueHandler implements ValidatorHandler {
    private Queue<ValidatorTicket> queue = new LinkedList<>();

    public ValidatorQueueHandler() {
        queue.add(new BusTicket(1988, "Narva"));
        queue.add(new BusTicket(2011, "Tartu"));
        queue.add(new BusTicket(1933, "Veriora"));
        queue.add(new BusTicket(1954, "Hiiumaa"));
        queue.add(new BusTicket(2012, "Kunda"));
        queue.add(new BusTicket(2001, "Kunda"));
        queue.add(new BusTicket(1999, "Ruhnu"));
        queue.add(new BusTicket(1950, "Piusa"));
        queue.add(new BusTicket(2007, "Rakvere"));
    }

    public boolean validationInQueue() {
        return !queue.isEmpty();
    }

    public ValidatorTicket nextValidation() {
        return queue.remove();
    }
}
