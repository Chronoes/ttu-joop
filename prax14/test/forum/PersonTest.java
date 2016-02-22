package forum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 12/3/15.
 */
public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("My Name");
    }

    @Test
    public void testWriteMessage() throws Exception {
        String content = "test";
        Message message = person.writeMessage(content);
        assertEquals(message.getContent(), content);
    }
}