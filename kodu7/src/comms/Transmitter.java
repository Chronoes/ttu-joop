package comms;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Chronoes on 01.11.2015.
 */
public class Transmitter {
    private final MessageEncoder encoder;
    private String currentPacket = "";

    public Transmitter(MessageEncoder encoder) {
        this.encoder = encoder;
    }

    public void addMessage(String message) {
        currentPacket += currentPacket.isEmpty() ? message : ";" + message;
    }

    public String getCurrentPacket() {
        return currentPacket;
    }

    public String transmit(String destination) {
        try (PrintStream file = new PrintStream(destination)) {
            file.print(encoder.pack(currentPacket));
        } catch (FileNotFoundException e) {
        }
        return destination;
    }
}
