package windows;

/**
 * Created by chronoes on 10/8/15.
 */
public class WindowController {
    public static boolean buttonState = false;

    public static OpenableWindow of(String type) {
        return type.equals("C") || type.equals("D") ? new RearWindow(type) : new OpenableWindow(type);
    }

    public static boolean toggleControlButton() {
        return buttonState = !buttonState;
    }
}
