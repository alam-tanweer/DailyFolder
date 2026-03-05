package unit08.moonbase.part2;

public class Control {
    private boolean available;

    public Control() {
        available = true;
    }
    
    public boolean accessTunnel() {
        boolean result = false;
        if(available) {
            result = true;
            available = false;
        }
        return result;
    }

    public void leaveTunnel() {
        available = true;
    }
}
