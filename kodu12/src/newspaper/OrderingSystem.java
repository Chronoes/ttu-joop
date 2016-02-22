package newspaper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronoes on 11/19/15.
 */
public class OrderingSystem {
    private static List<BaseOrder> orders = new ArrayList<>();

    public static synchronized void addOrder(BaseOrder order) {
        orders.add(order);
    }

    public static synchronized void processOrder(OrderHandler handler) {
        if (orders.size() > 0) {
            handler.process(orders.remove(0));
        }
    }

    public static void main(String[] args) {
        Thread orderGen = new Thread(new OrderGenerator());
        orderGen.start();

        Thread orderHandler1 = new Thread(new OrderHandler("orderHandler1"));
        Thread orderHandler2 = new Thread(new OrderHandler("orderHandler2"));
        Thread orderHandler3 = new Thread(new OrderHandler("orderHandler3"));
        Thread orderHandler4 = new Thread(new OrderHandler("orderHandler4"));

        orderHandler1.start();
        orderHandler2.start();
        orderHandler3.start();
        orderHandler4.start();

        try {
            Thread.sleep(5500);
//            orderGen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        orderGen.interrupt();
        orderHandler1.interrupt();
        orderHandler2.interrupt();
        orderHandler3.interrupt();
        orderHandler4.interrupt();
    }

}
