package newspaper;

/**
 * Created by chronoes on 11/19/15.
 */
public class BusinessCustomerOrder extends BaseOrder {
    private int registrationNumber;

    public BusinessCustomerOrder(String name, String address, int id, int orderLengthMonths, int exemplars, int registrationNumber) {
        super(name, address, id, orderLengthMonths, exemplars);
        this.registrationNumber = registrationNumber;
    }

    @Override
    public int getExemplarsPerWeek() {
        return exemplars * 5;
    }

    @Override
    public String toString() {
        return String.format(
                "ID %d: Business customer: %s, registration number: %d address: %s\n" +
                "Order length (months): %d, exemplars: %d",
                clientId, clientName, registrationNumber, address,
                orderLengthMonths, exemplars
        );
    }
}
