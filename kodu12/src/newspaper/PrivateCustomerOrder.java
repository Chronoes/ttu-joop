package newspaper;

/**
 * Created by chronoes on 11/19/15.
 */
public class PrivateCustomerOrder extends BaseOrder {
    public PrivateCustomerOrder(String name, String address, int id, int orderLengthMonths, int exemplars) {
        super(name, address, id, orderLengthMonths, exemplars);
    }

    @Override
    public int getExemplarsPerWeek() {
        return exemplars * 6;
    }

    @Override
    public String toString() {
        return String.format(
                "ID %d: Private customer: %s, address: %s\n" +
                "Order length (months): %d, exemplars: %d",
                clientId, clientName, address,
                orderLengthMonths, exemplars
        );
    }
}
