package unit11;

/**
 * A simple class that starts counting at some specified time and can be
 * incremented.
 * 
 * @author GCCIS Faculty
 */
public class Clock {
    /**
     * The units for a clock.
     */
    public enum Units {
        MILLISECONDS("ms", 1),
        SECONDS("seconds", 1000),
        MINUTES("minutes", 60000),
        HOURS("hours", 360000);

        private final String unitString;
        private final long timeBetweenTicks;

        private Units(String unitString, long msBetweenTicks) {
            this.unitString = unitString;
            this.timeBetweenTicks = msBetweenTicks;
        }

        public long getTimeBetweenTicks() {
            return timeBetweenTicks;
        }

        @Override
        public String toString() {
            return unitString;
        }
    }

    /**
     * The current time.
     */
    private int time;

    /**
     * The units for this clock.
     */
    private final Units units;
    
    /**
     * Convenience constructor that starts the clock at -10 seconds.
     */
    public Clock() {
        this(-10, Units.SECONDS);
    }

    /**
     * Starts the clock at the specified time.
     * 
     * @param startTime The start time for the new clock. It will count up 
     * from here.
     * @param units The units for this clock.
     */
    public Clock(int startTime, Units units) {
        this.time = startTime;
        this.units = units;
    }

    /**
     * Returns the current time.
     * 
     * @return The current time.
     */
    public int getTime() {
        return time;
    }

    /**
     * Returns the amount of time (in milliseconds) that should elapse between
     * increments of the clock time.
     * 
     * @return The time between ticks of this clock.
     */
    public long getTimeBetweenTicks() {
        return units.getTimeBetweenTicks();
    }

    /**
     * Returns the units for this clock.
     * 
     * @return The units for this clock.
     */
    public Units getUnits() {
        return units;
    }

    /**
     * Increments the clock by one unit.
     */
    public void increment() {
        time++;
    }

    /**
     * Returns a string representation of the clock in the format 
     * "T+/-<time> <units>", e.g. "T-10 seconds" or "T+15 minutes".
     */
    @Override
    public String toString() {
        String string = "T";
        if(time >= 0) {
            string += "+";
        }
        return string + time + " " + units;
    }
}
