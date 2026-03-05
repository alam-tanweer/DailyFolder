package unit08.racing;

public class RunnableRace {
    public static void runnables () {
        RunnableRacer r1 = new RunnableRacer ("Mario", 10, true);
        RunnableRacer r2 = new RunnableRacer ("Peach", 10, true);
        RunnableRacer r3 = new RunnableRacer ("Luigi", 10, true);

        Thread racer1 = new Thread(r1);
        Thread racer2 = new Thread(r2);
        Thread racer3 = new Thread(r3);

        racer1.start();
        racer2.start();
        racer3.start();

        while (racer1.isAlive() || racer2.isAlive() || racer3.isAlive()) {
            // Wait for all racers to finish
        }

        System.out.println (r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
        System.out.println (r2.getName() + " Finished in " + r2.getFinishTime() + " seconds");
        System.out.println (r3.getName() + " Finished in " + r3.getFinishTime() + " seconds");
    }


    public static void main(String[] args) {
        // Activity 8.5/8.6
        runnables();

        // Activity 8.13/8.14
        // executors();
    }    
}
