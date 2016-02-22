package airlineservice;
import lufthavn.GateTicket;
import lufthavn.RegularTicket;
import lufthavn.SilverTicket;
import lufthavn.GoldTicket;
import java.util.Stack;

public class AirlineTicketServiceImpl implements AirlineTicketService {
    private Stack<GateTicket> gateTickets = new Stack<>();

    public AirlineTicketServiceImpl() {
        gateTickets.push(new GoldTicket("Marten Tarkin", "126488", 16.21));
        gateTickets.push(new RegularTicket("Marten Truu", "151863", 10.1));
        gateTickets.push(new RegularTicket("Uku Markus Tammet", "844626", 20.38));
        gateTickets.push(new SilverTicket("Rain Vink", "111121", 50.55));
        gateTickets.push(new GoldTicket("1337 M45t3r", "31337", 13.37));
    }

    @Override
    public boolean hasNextTicket() {
        return !gateTickets.isEmpty();
    }

    @Override
    public GateTicket getNextTicket() {
        return gateTickets.pop();
    }
}