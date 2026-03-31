package unit11;

public class NameThreadSleep implements Runnable {
    private final String name;
    private final int index;

    public NameThreadSleep(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        // sleep method
        try {
            Thread.sleep(index * 500);
        } catch (InterruptedException e) {
            // squash
        }

        System.out.print(name.charAt(index));
    }

    public static void main(String[] args) {
        String name = "Bobby";
        for(int i=0; i<name.length(); i++) {
            NameThreadSleep nts = new NameThreadSleep(name, i);
            Thread thread = new Thread(nts);
            thread.start();
        }
    }
    
}
