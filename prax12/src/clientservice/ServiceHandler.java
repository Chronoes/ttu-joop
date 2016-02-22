package clientservice;

/**
 * Created by chronoes on 11/19/15.
 */
public class ServiceHandler implements Runnable {
    private String name;

    public ServiceHandler(String name) {
        this.name = name;
    }

    public void handleTicket(ServiceTicket ticket) {
        System.out.println(name + " is handling " + ticket.toString());
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            TicketSystem.processTickets(this);
        }
    }
}
