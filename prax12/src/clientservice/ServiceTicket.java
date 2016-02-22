package clientservice;

/**
 * Created by chronoes on 11/19/15.
 */
public class ServiceTicket {
    private int id;

    public ServiceTicket(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client " + id;
    }
}
