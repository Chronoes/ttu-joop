package lufthavn;

public class GateDataReceiverImpl implements GateDataReceiver {
    public void addTicket(GateTicket ticket) throws IllegalArgumentException {
        System.out.printf("Registreeritud pilet nr %s: %s (%.2f€)\n",
                          ticket.getTicketCode(), ticket.getPassengerName(), ticket.getCost());
    }
}