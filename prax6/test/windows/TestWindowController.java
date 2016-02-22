package windows;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by chronoes on 10/8/15.
 */
public class TestWindowController {
    private Map<String, OpenableWindow> windows;

    @Before
    public void setUp() throws Exception {
        windows = new HashMap<>();
        windows.put("A", new OpenableWindow("A"));
        windows.put("B", new OpenableWindow("B"));
        windows.put("C", new OpenableWindow("C"));
        windows.put("D", new OpenableWindow("D"));
    }

    @Test
    public void testControlButton() throws Exception {
        for (String type: windows.keySet()) {
            OpenableWindow window = windows.get(type);

            window.openPartial();
            assertEquals(2, window.getState());
            window.openFull();
            assertEquals(10, window.getState());
            window.openPartial();
            assertEquals(10, window.getState());
            window.closePartial();
            assertEquals(8, window.getState());
            window.closeFull();
            assertEquals(0, window.getState());
            window.closePartial();
            assertEquals(0, window.getState());
            window.openPartial();
            assertEquals(2, window.getState());
        }

        assertEquals(true, WindowController.toggleControlButton());
        for (String type: windows.keySet()) {
            OpenableWindow window = windows.get(type);

            window.openPartial();
            window.closeFull();

        }

    }
}
