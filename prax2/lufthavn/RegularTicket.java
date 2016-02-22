package lufthavn;
public class RegularTicket extends GeneralTicket {
    private double discount = 0.0;

    public RegularTicket(String name, String code, double price) {
        super(name, code, price);
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}