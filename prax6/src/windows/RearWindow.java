package windows;

/**
 * Created by chronoes on 10/8/15.
 */
public class RearWindow extends OpenableWindow {
    private boolean isBlocked = false;

    RearWindow(String type) {
        super(type);
    }

    public boolean block(boolean state) {
        return isBlocked = state;
    }

    private String blockedToString() {
        return "Windows are currently blocked. " + toString();
    }

    @Override
    public void openPartial() {
        if (!isBlocked) {
            super.openPartial();
        } else {
            System.out.println(blockedToString());
        }
    }

    @Override
    public void openFull() {
        if (!isBlocked) {
            super.openFull();
        } else {
            System.out.println(blockedToString());
        }
    }

}
