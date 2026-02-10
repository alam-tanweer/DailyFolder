package unit05;

public class Lockable<T> extends Container<T> {
    private boolean locked;

    public Lockable(T value) {
        super(value);
        locked = false;
    }

    public void toggleLock() {
        locked = !locked;
    }

    @Override
    public T getValue() {
        return locked ? null : super.getValue();
    }
}
