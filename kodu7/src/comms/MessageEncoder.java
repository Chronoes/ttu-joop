package comms;

/**
 * Created by Chronoes on 01.11.2015.
 */
public class MessageEncoder {
    public String pack(String message) {
        return message.replaceAll("[AEIYOUÕÄÖÜaeiyouõäöü]+", "");
    }
}
