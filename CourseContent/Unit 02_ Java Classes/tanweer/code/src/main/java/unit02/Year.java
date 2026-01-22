package unit02;

import java.util.Arrays;
import java.util.Random;

/**
 * Year class provide several capablity
 * 
 * @author : Tanweer Alam
 * @since : 01/22/2026
 * 
 */
public class Year {

    public static final int DAYS_IN_YEAR = 365;
    // private static final Random RNG = new Random(12);    
    private static final Random RNG = new Random();   

    // 2.19
    private int yearNumber;

    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    /**
     * This function compute number of days in a year
     * 
     * @return number of days
     */

    public int numberOfDays() {
        return getDaysInYear(yearNumber);
    }
    // 2.19

    // 2.18
    /**
     * 
     * @param year
     * @return number of days
     */
    public static int getDaysInYear(int year) {
        if (year % 400 == 0) {
            return DAYS_IN_YEAR + 1;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return DAYS_IN_YEAR + 1;
        } else {
            return DAYS_IN_YEAR;
        }
    }

    // 2.21
    @Override
    public String toString() {
        return "Year {"
                + "year=" + this.yearNumber
                + ", days=" + getDaysInYear(this.yearNumber)
                + "}";
    }

    public static Year[] parseYears(String years) {
        String[] tokens = years.split(" ");
        Year[] array = new Year[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            int yearNumber = Integer.parseInt(tokens[i]);
            array[i] = new Year(yearNumber);
        }

        return array;
    }

    public static Year randomYear() {
        // int bound = 2021 - 1900 + 1;
        // int yearNumber = RNG.nextInt(bound) + 1900;
        int yearNumber = RNG.nextInt(1900,2024);
        return new Year(yearNumber);
    }

    public static void main(String[] args) {
        // 2.18
        System.out.println("Year 2000: " + Year.getDaysInYear(2000));
        System.out.println("Year 1990: " + Year.getDaysInYear(1990));

        // 2.19
        Year y2000 = new Year(2000);
        Year y1990 = new Year(1990);
        System.out.println("2000 : " + y2000.numberOfDays());
        System.out.println("1990 : " + y1990.numberOfDays());

        // 2.23
        Year[] years = parseYears("2000 2021");
        System.out.println(Arrays.toString(years));

        //2.24
        System.out.println(randomYear());
        System.out.println(randomYear());
        System.out.println(randomYear());        
    }

}
