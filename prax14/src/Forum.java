import forum.Board;
import forum.Message;

/**
 * Created by chronoes on 12/3/15.
 */
public class Forum {
    private static Board forumBoard = new Board();

    public static synchronized void postMessage(Message message) {
        forumBoard.addMessage(message);
    }

    public static void main(String[] args) {

    }
}
