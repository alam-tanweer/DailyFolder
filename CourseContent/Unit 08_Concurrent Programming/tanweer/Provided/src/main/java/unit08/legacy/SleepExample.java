package unit08.legacy;

public class SleepExample {

    public void goToSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }
    
}
