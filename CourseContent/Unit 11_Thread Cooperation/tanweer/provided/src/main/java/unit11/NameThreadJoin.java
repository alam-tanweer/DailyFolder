package unit11;

public class NameThreadJoin implements Runnable {
    private final Thread previous;
    private final String name;
    private final int index;

    public NameThreadJoin(Thread previous, String name, int index) {
        this.previous = previous;
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        // join
        if(previous != null) {
            try {
                previous.join();
            } catch (InterruptedException e) {
                // squash
            }
        }

        System.out.print(name.charAt(index));
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "Bobby";
        Thread previous = null;
        for(int i=0; i<name.length(); i++) {
            NameThreadJoin ntj = new NameThreadJoin(previous, name, i);
            previous = new Thread(ntj);
            previous.start();
        }

        previous.join();
        System.out.println("!");
    }
}
