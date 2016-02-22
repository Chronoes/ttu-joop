package vehiclerent;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by chronoes on 12/10/15.
 */
abstract class VehicleSeller implements Runnable {
    private static final Random rng = new Random();
    private static int vehicleCount = 0;

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
        while (!Thread.interrupted() && vehicleCount < 200) {
            Vehicle vehicle = getVehicle(BigDecimal.valueOf(randomInt(10, 200)), randomInt(2005, 2015), randomString(20));
            RentingSystem.addVehicle(vehicle);
            vehicleCount++;
            try {
                Thread.sleep(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract Vehicle getVehicle(BigDecimal pricePerDay, int registrationYear, String maker);
}
