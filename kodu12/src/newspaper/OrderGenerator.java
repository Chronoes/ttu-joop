package newspaper;

import java.util.Random;

/**
 * Created by chronoes on 11/19/15.
 */
public class OrderGenerator implements Runnable {
    private static final Random rng = new Random();

    public static String randomString(int length) {
        char[] text = new char[length];
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz -";
        characters += characters.toUpperCase();
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(randomInt(characters.length()));
        }
        return new String(text);
    }

    public static int randomInt(int start, int stop) {
        return start + rng.nextInt(stop - start);
    }

    public static int randomInt(int stop) {
        return rng.nextInt(stop);
    }

    @Override
    public void run() {
        int privateLessThanSixMonthsLimit = 900;
        int businessLessThanSixMonthsLimit = 450;
        int businessMoreThanSixMonthsLimit = 250;
        int customerId = 1;
        while (!Thread.interrupted() && (privateLessThanSixMonthsLimit > 0 || businessLessThanSixMonthsLimit > 0 || businessMoreThanSixMonthsLimit > 0)) {
            switch (randomInt(0, 3)) {
                case 0:
                    if (privateLessThanSixMonthsLimit > 0) {
                        OrderingSystem.addOrder(new PrivateCustomerOrder(randomString(20), randomString(50), customerId++, randomInt(1, 6), randomInt(1, 4)));
                        privateLessThanSixMonthsLimit--;
                        break;
                    }
                case 1:
                    if (businessLessThanSixMonthsLimit > 0) {
                        OrderingSystem.addOrder(new BusinessCustomerOrder(randomString(20), randomString(50), customerId++, randomInt(1, 6), randomInt(1, 20), randomInt(100000000, 999999999)));
                        businessLessThanSixMonthsLimit--;
                        break;
                    }
                case 2:
                    if (businessMoreThanSixMonthsLimit > 0) {
                        OrderingSystem.addOrder(new BusinessCustomerOrder(randomString(20), randomString(50), customerId++, randomInt(6, 36), randomInt(1, 50), randomInt(100000000, 999999999)));
                        businessMoreThanSixMonthsLimit--;
                        break;
                    }
                default:
                    break;
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
