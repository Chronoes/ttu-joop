package newspaper;

import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * Created by chronoes on 11/19/15.
 */
abstract class BaseOrder {
    protected String clientName;
    protected String address;
    protected int clientId;
    protected int orderLengthMonths;
    protected int exemplars;

    BaseOrder(String name, String address, int id, int orderLengthMonths, int exemplars) {
        clientName = name;
        this.address = address;
        clientId = id;
        this.orderLengthMonths = orderLengthMonths;
        this.exemplars = exemplars;
    }

    public abstract int getExemplarsPerWeek();

    public BigDecimal calculatePrice(BiFunction<Integer, Integer, BigDecimal> priceHandler) {
        return priceHandler.apply(getExemplarsPerWeek(), orderLengthMonths);
    }
}
