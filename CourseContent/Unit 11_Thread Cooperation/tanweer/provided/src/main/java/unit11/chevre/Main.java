package unit11.chevre;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClubChevre club = new ClubChevre();

        TrollBouncer troll = new TrollBouncer(club);
        Thread trollThread = new Thread(troll);
        trollThread.start();

        while(true) {
            Goat goat = new Goat(club);
            Thread thread = new Thread(goat);
            thread.start();
            Thread.sleep(Utils.getRandomNumber(0, 1000));
        }
    }
}
