package unit08.racing;

/** 8.5 **/
public class ThreadRace {
    public static void main(String[] args) {
        ThreadRacer r1 = new ThreadRacer ("Mario", 10, true);
        ThreadRacer r2 = new ThreadRacer ("Peach", 10, true);
        ThreadRacer r3 = new ThreadRacer ("Luigi", 10, true);

        r1.start();
        r2.start();
        r3.start();

        /** 8.6 **/
        while (r1.isAlive() || r2.isAlive() || r3.isAlive()) {
            // Wait for all racers to finish
        }

        System.out.println (r1.getRacerName() + " Finished in " + r1.getFinishTime() + " seconds");
        System.out.println (r2.getRacerName() + " Finished in " + r2.getFinishTime() + " seconds");
        System.out.println (r3.getRacerName() + " Finished in " + r3.getFinishTime() + " seconds");

        r1.start();
        r2.start();
        r3.start();
    }
}
