package unit10.duplexer;

public abstract class Duplexer implements AutoCloseable {
    private boolean debug;

    public Duplexer() {
        this(false);
    }

    public Duplexer(boolean debug) {
        this.debug = debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    protected void debug(String message) {
        if (debug) {
            System.out.println(message);
        }
    }

    public abstract void send(String message);
    public abstract String receive();
}
