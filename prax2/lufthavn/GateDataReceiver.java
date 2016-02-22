package lufthavn;
public interface GateDataReceiver {
    public void addTicket(GateTicket ticket) throws IllegalArgumentException;
}