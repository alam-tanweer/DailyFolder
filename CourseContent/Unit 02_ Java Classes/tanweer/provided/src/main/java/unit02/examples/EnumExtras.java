package unit02.examples;

import java.util.Arrays;

public class EnumExtras {
    public static void main(String[] args) {
        String kelvin = BoilingPoint.KELVIN.toString();
        System.out.println(kelvin);

        BoilingPoint[] values = BoilingPoint.values();
        System.out.println(Arrays.toString(values));

        BoilingPoint celsius = BoilingPoint.valueOf("CELSIUS");
        System.out.println(celsius);

        // BoilingPoint error = BoilingPoint.valueOf("oops"); // exception
        // System.out.println(error);
    }
    
}
