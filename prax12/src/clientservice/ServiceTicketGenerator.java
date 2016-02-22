package clientservice;

/**
 * Created by chronoes on 11/19/15.
 */
public class ServiceTicketGenerator implements Runnable {
    private int currentId = 0;
    private String idPrefix;

    public ServiceTicketGenerator(String idPrefix) {
        this.idPrefix = idPrefix;
    }

    public ServiceTicket createTicket() {
        currentId++;
        return new ServiceTicket(getCurrentId());
    }

    public int getCurrentId() {
        return Integer.parseInt(idPrefix + Integer.toString(currentId));
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            TicketSystem.addTicket(createTicket());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
