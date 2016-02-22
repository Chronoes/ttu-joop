package lufthavn;
public class GoldTicket extends GeneralTicket {
    private double discount = 0.5;

    public GoldTicket(String name, String code, double price) {
        super(name, code, price);
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}