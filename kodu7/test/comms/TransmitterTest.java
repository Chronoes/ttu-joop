package comms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by Chronoes on 01.11.2015.
 */
public class TransmitterTest {
    private Transmitter transmitter;
    private MessageEncoder encoder;

    @Before
    public void setUp() throws Exception {
        encoder = mock(MessageEncoder.class);
        transmitter = new Transmitter(encoder);
    }

    @Test
    public void testAddMessage() throws Exception {
        transmitter.addMessage("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda");
        assertEquals("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda", transmitter.getCurrentPacket());
    }

    @Test
    public void testAddMultipleMessages() throws Exception {
        transmitter.addMessage("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda");
        transmitter.addMessage("Muuhulgas on nende repertuaaris ansambli Jääääri laulud.");
        assertEquals("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda;" +
                "Muuhulgas on nende repertuaaris ansambli Jääääri laulud.", transmitter.getCurrentPacket());
    }

    @Test
    public void testTransmit() throws Exception {
        transmitter.addMessage("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda");
        transmitter.addMessage("Muuhulgas on nende repertuaaris ansambli Jääääri laulud.");
        when(encoder.pack(anyString())).thenReturn("vstsm  lvndlg, sndd n kllsd j skvd lld;" +
                "Mhlgs n nnd rprtrs nsmbl Jr lld.");
        assertEquals("test.txt", transmitter.transmit("test.txt"));
        verify(encoder).pack("Avastasime uue elevandiliigi, isendid on kollased ja oskavad laulda;" +
                "Muuhulgas on nende repertuaaris ansambli Jääääri laulud.");
    }
}