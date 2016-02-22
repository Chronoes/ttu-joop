package airlinecontroller;
import lufthavn.GateDataReceiver;
import lufthavn.GateDataReceiverImpl;
import airlineservice.AirlineTicketService;
import airlineservice.AirlineTicketServiceImpl;

public class AirlineController {
    private AirlineTicketService airlineTicketService;
    private GateDataReceiver gateDataReceiver;

    public AirlineController() {
        airlineTicketService = new AirlineTicketServiceImpl();
        gateDataReceiver = new GateDataReceiverImpl();
    }

    public void processTickets() {
        while (airlineTicketService.hasNextTicket()) {
            gateDataReceiver.addTicket(airlineTicketService.getNextTicket());
        }
    }
}