package unit08.assignment.part2;

public class Bridge {
    private boolean open;

    public Bridge() {
        open = true;
    }

    public boolean enterBridge() {
        boolean result = false;
        if(open) {
            result = true;
            open = false;
        }
        return result;
    }

    public void leaveBridge() {
        open = true;
    }
}
