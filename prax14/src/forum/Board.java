package forum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronoes on 12/3/15.
 */
public class Board {
    private final List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public int getMessageCount() {
        return messages.size();
    }
}
