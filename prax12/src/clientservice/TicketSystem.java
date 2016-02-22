package clientservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronoes on 11/19/15.
 */
public class TicketSystem {
    private static final List<ServiceTicket> tickets = new ArrayList<>();

    public static void addTicket(ServiceTicket ticket) {
        synchronized (tickets) {
            tickets.add(ticket);
        }
    }

    public static void processTickets(ServiceHandler handler) {
        synchronized (tickets) {
            if (tickets.size() > 0) {
                handler.handleTicket(tickets.remove(0));
            }
        }
    }

    public static void main(String[] args) {
        Thread generator11 = new Thread(new ServiceTicketGenerator("11"));
        Thread generator12 = new Thread(new ServiceTicketGenerator("12"));

        generator11.start();
        generator12.start();

        Thread handler1 = new Thread(new ServiceHandler("Box 1"));
        Thread handler2 = new Thread(new ServiceHandler("Box 2"));
        Thread handler3 = new Thread(new ServiceHandler("Box 3"));
        Thread handler4 = new Thread(new ServiceHandler("Box 4"));

        handler1.start();
        handler2.start();
        handler3.start();
        handler4.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        generator11.interrupt();
        generator12.interrupt();

        handler1.interrupt();
        handler2.interrupt();
        handler3.interrupt();
        handler4.interrupt();
    }
}
