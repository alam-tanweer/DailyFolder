package unit08.practicum.clock;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class ClockWall {
    private interface Clock {
        String getTime ();
    }

    private static String adjustedTime (int offset) {
        LocalTime now = LocalTime.now (ZoneOffset.UTC);
        int hour = now.getHour ();
        String amPm = "AM";
        hour = hour + offset;
        if (hour > 24) {
            hour = hour - 24;
        }
        else if (hour < 0) {
            hour = hour + 24;
        }
        if (hour == 0) {
            hour += 12;
        }
        else if (hour > 12) {
            hour = hour - 12;
            amPm = "PM";
        }
        return (hour + ":" + now.getMinute() + " " + amPm);
    }

    public static void main(String[] args) {
        Map<String, Clock> clocks = new HashMap<>();
        clocks.put ("New York", ()->adjustedTime (-4));
        clocks.put ("Tokyo", ()->adjustedTime (9));

        for (String city : clocks.keySet()) {
            System.out.println (city + " - " + clocks.get (city).getTime());
        }
    }
}
