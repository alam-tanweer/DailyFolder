package unit02;

import java.util.Arrays;
import java.util.Random;

public class Year {
    public static final int DAYS_IN_YEAR = 365;

    private static final Random RNG = new Random();

    private final int yearNumber;

    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public int getYear() {
        return yearNumber;
    }

    public int numberOfDays() {
        return getDaysInYear(yearNumber);
    }

    public static Year randomYear() {
        int bound = 2021 - 1900 + 1;
        int yearNumber = RNG.nextInt(bound) + 1900;
        return new Year(yearNumber);
    }

    public static int getDaysInYear(int year) {
        if(year % 400 == 0) {
            return DAYS_IN_YEAR + 1;
        } else if(year % 100 != 0 && year % 4 == 0) {
            return DAYS_IN_YEAR + 1;
        } else {
            return DAYS_IN_YEAR;
        }
    }

    public static Year[] parseYears(String years) {
        String[] tokens = years.split(" ");
        Year[] array = new Year[tokens.length];
        for(int i=0; i<tokens.length; i++) {
            int yearNumber = Integer.parseInt(tokens[i]);
            array[i] = new Year(yearNumber);
        }
        
        return array;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Year) {
            Year other = (Year)obj;
            return this.yearNumber == other.yearNumber;
        } else {
            return false;
        }
    }

    @Override 
    public String toString() {
        return "Year{"
            + "year=" + this.yearNumber
            + ", days=" + getDaysInYear(this.yearNumber)
            + "}";
    }

    public static void main(String[] args) {
        Year y2000 = new Year(2000);
        System.out.println(y2000);
        Year y2020 = new Year(2020);
        System.out.println(y2020);
        Year y2021 = new Year(2021);
        System.out.println(y2021);
        Year y2100 = new Year(2100);
        System.out.println(y2100);

        Year y2020Too = new Year(2020);
        System.out.println(y2020.equals(y2020Too));
        System.out.println(y2020.equals(y2100));

        Year[] years = parseYears("2000 2021");
        System.out.println(Arrays.toString(years));

        System.out.println(randomYear());
        System.out.println(randomYear());
        System.out.println(randomYear());
    }
    
}
