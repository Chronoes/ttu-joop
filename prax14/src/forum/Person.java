package forum;

/**
 * Created by chronoes on 12/3/15.
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Message writeMessage(String content) {
        return new Message(this, content);
    }
}
