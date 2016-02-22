package windows;

/**
 * Created by chronoes on 10/8/15.
 */
public class OpenableWindow {
    protected static final int WINDOW_CLOSED = 0;
    protected static final int WINDOW_OPEN = 10;

    protected int openState = WINDOW_CLOSED;
    protected String type = "A";

    OpenableWindow() {}

    OpenableWindow(String windowType) {
        type = windowType;
    }

    @Override
    public String toString() {
        return "Window: " + type + ", state: " + openState;
    }

    protected boolean isWithinLimit() {
        return WINDOW_OPEN >= openState && WINDOW_CLOSED <= openState;
    }

    public void openPartial() {
        openState += 2;
        if (!isWithinLimit()) {
            openFull();
        }
    }

    public void closePartial() {
        openState -= 2;
        if (!isWithinLimit()) {
            closeFull();
        }
    }

    public void openFull() {
        openState = WINDOW_OPEN;
    }

    public void closeFull() {
        openState = WINDOW_CLOSED;
    }

    public int getState() {
        return openState;
    }
}
