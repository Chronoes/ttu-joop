package lufthavn;
public abstract class GeneralTicket implements GateTicket {
    private String name;
    private String code;
    private double price;

    public GeneralTicket(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public abstract double getDiscount();

    @Override
    public String getPassengerName() {
        return name;
    }

    @Override
    public String getTicketCode() {
        return code;
    }

    @Override
    public double getCost() {
        return price * (1.0 - getDiscount());
    }
}