package unit08.racing;

//8.2
public class Race {

    public static void main(String[] args) {
        Racer r1 = new Racer("Mario", 10, true);
        Racer r2 = new Racer("Peach", 10, true);
        Racer r3 = new Racer("Luigi", 10, true);

        r1.race();
        r2.race();
        r3.race();

        System.out.println(r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
        System.out.println(r2.getName() + " Finished in " + r2.getFinishTime() + " seconds");
        System.out.println(r3.getName() + " Finished in " + r3.getFinishTime() + " seconds");
    }

}
