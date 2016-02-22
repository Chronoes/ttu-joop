import forum.Person;

/**
 * Created by chronoes on 12/3/15.
 */
public class Poster implements Runnable {
    private Person poster;

    public Poster(Person person) {
        poster = person;
    }

    @Override
    public void run() {
        Forum.postMessage(poster.writeMessage("test"));
    }
}
