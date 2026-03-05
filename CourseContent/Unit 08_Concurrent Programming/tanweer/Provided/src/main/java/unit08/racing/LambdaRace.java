package unit08.racing;

/** Activity 8.8 **/
public class LambdaRace {

    public static void main(String[] args) {
        Racer r1 = new Racer ("Mario", 10, true);
        Racer r2 = new Racer ("Peach", 10, true);
        Racer r3 = new Racer ("Luigi", 10, true);

        Thread racer1 = new Thread(r1::race);
        Thread racer2 = new Thread(r2::race);
        Thread racer3 = new Thread(r3::race);

        racer1.start();
        racer2.start();
        racer3.start();

        // while (racer1.isAlive() || racer2.isAlive() || racer3.isAlive()) {
        //     // Wait for all racers to finish
        // }

        System.out.println (r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
        System.out.println (r2.getName() + " Finished in " + r2.getFinishTime() + " seconds");
        System.out.println (r3.getName() + " Finished in " + r3.getFinishTime() + " seconds");
    }
}
