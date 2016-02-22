package windows;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 10/8/15.
 */
public class TestOpenableWindow {
    private OpenableWindow window;

    @Before
    public void setUp() throws Exception {
        window = new OpenableWindow();
    }

    @Test
    public void testOpen() throws Exception {
        window.openPartial();
        assertEquals(2, window.getState());
        window.openPartial();
        assertEquals(4, window.getState());
    }

    @Test
    public void testOpenOverLimit() throws Exception {
        for (int i = 0; i < 6; i++) {
            window.openPartial();
        }
        assertEquals(10, window.getState());
    }

    @Test
    public void testClose() throws Exception {
        window.openPartial();
        window.openPartial();
        assertEquals(4, window.getState());
        window.closePartial();
        assertEquals(2, window.getState());
        window.closePartial();
        assertEquals(0, window.getState());
    }

    @Test
    public void testCloseOverLimit() throws Exception {
        window.openPartial();
        assertEquals(2, window.getState());
        window.closePartial();
        assertEquals(0, window.getState());
        window.closePartial();
        assertEquals(0, window.getState());
    }


}
