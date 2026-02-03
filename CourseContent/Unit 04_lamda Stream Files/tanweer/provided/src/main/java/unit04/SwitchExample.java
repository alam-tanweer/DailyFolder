package unit04;

public class SwitchExample {
    public static void main (String[] args) {
        String day = "Tuesday";
        String activity;

        switch (day) {
            case "Monday":
                activity = "Go to the gym";
                break;
            case "Tuesday":
                activity = "Attend coding class";
                break;
            case "Wednesday":
                activity = "Work on project";
                break;
            case "Thursday":
                activity = "Team meeting";
                break;
            case "Friday":
                activity = "Review week's work";
                break;
            default:
                activity = "Relax and unwind";
                break;
        }

        System.out.println ("Activity for " + day + ": " + activity);
    }
}