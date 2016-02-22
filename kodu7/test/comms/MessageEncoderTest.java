package comms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chronoes on 01.11.2015.
 */
public class MessageEncoderTest {
    private MessageEncoder encoder;

    @Before
    public void setUp() throws Exception {
        encoder = new MessageEncoder();
    }

    @Test
    public void testPacking() throws Exception {
        assertEquals("Tstng mthd pckng: Mxd spcl chrs - sl plvrnnkl J-RL plttd knld",
                encoder.pack("Testing method packing: Mixed special chars - Öisel palverännakul JÄÄ-ÄÄREL põletatud küünlad"));
    }
}