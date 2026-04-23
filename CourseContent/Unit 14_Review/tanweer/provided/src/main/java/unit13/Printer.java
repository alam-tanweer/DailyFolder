package unit13;

public class Printer extends Thread {
    private final String theString;

    public Printer(String theString) {
        this.theString = theString;
    }

    @Override
    public void run() {
        for(char c : theString.toCharArray()) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Printer thread = new Printer("Send Help!");
        thread.start();
    }
    
}
