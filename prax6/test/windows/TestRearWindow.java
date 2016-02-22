package windows;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chronoes on 10/8/15.
 */
public class TestRearWindow {
    private RearWindow window;

    @Before
    public void setUp() throws Exception {
        window = new RearWindow("C");
    }

    @Test
    public void testOpen() throws Exception {
        window.openPartial();
        assertEquals(2, window.getState());
        window.block(true);
        window.openPartial();
        assertEquals(2, window.getState());
    }
}
