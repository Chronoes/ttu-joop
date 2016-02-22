package lufthavn;
public class SilverTicket extends GeneralTicket {
    private double discount = 0.25;

    public SilverTicket(String name, String code, double price) {
        super(name, code, price);
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}