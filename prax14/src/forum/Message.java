package forum;

import java.time.LocalDateTime;

/**
 * Created by chronoes on 12/3/15.
 */
public class Message {
    private final LocalDateTime createdAt = LocalDateTime.now();
    private Person author;
    private String content;
    private int likes = 0;

    public Message(Person author, String content) {
        this.author = author;
        this.content = content;
    }

    public int addLike() {
        return ++likes;
    }

    public String getContent() {
        return content;
    }
}
