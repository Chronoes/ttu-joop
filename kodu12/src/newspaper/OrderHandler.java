package newspaper;

import java.math.BigDecimal;

/**
 * Created by chronoes on 11/19/15.
 */
public class OrderHandler implements Runnable {
    public static final BigDecimal EXEMPLAR_PRICE = BigDecimal.valueOf(0.55);
    public static final BigDecimal DISCOUNT_PERCENT = BigDecimal.valueOf(0.10);
    public static final int DISCOUNT_STARTING_MONTHS = 6;
    private String name;

    public OrderHandler(String name) {
        this.name = name;
    }

    private static BigDecimal calcPrice(int exemplarsPerWeek, int orderLengthMonths) {
        BigDecimal price = BigDecimal.valueOf(exemplarsPerWeek).multiply(EXEMPLAR_PRICE).multiply(BigDecimal.valueOf(orderLengthMonths * 4));
        return orderLengthMonths >= DISCOUNT_STARTING_MONTHS ? price.multiply(BigDecimal.ONE.subtract(DISCOUNT_PERCENT)) : price;
    }

    public void process(BaseOrder order) {
        System.out.printf("%s -- processing...\n%s, price: %.2f\n-- finished\n", name, order.toString(), order.calculatePrice(OrderHandler::calcPrice));
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            OrderingSystem.processOrder(this);
        }
    }
}
