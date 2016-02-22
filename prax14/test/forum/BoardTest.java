package forum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by chronoes on 12/3/15.
 */
public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void testAddMessage() throws Exception {
        Message message = mock(Message.class);
        board.addMessage(message);
        assertEquals(1, board.getMessageCount());
        board.addMessage(message);
        assertEquals(2, board.getMessageCount());
    }
}