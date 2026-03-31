package unit11.chevre;

public class TrollBouncer implements Runnable {
    private final ClubChevre club;

    public TrollBouncer(ClubChevre club) {
        this.club = club;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (club) {
                // if there is room in the club and goats in line...
                while(!club.isAtCapacity() && club.numberOfGoatsInLine() > 0) {
                    // choose the next goat and remove it from the line
                    Goat goat = chooseGoat();
                    club.removeGoatFromLine(goat);
                    club.startDancing(goat);
                    System.out.println("The Troll Bouncer lets " +
                            goat.getName() +
                            " into the club. There are now " +
                            club.numberOfDancingGoats() +
                            " goats on the dance floor.");

                    // notify the goat that it has been picked
                    synchronized(goat) {
                        goat.notify();
                    }
                }
                // the club is full or the line is empty, so wait for another
                // goat to get in line or exit the club
                try {
                    club.wait();
                } catch(InterruptedException ie) {
                    // squash
                }
            }
        }
    }

    private Goat chooseGoat() {
        Goat chosen = null;
        double best = 0;

        double length = club.numberOfGoatsInLine();
        for(double position=0; position<length; position++) {
            Goat candidate = club.getGoatAtPosition((int)position);
            double score = length / (position + 1) * candidate.getCoolness();
            if(score > best) {
                best = score;
                chosen = candidate;
            }
        }
        return chosen;
    }
}
