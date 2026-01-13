package unit01.spring2026.assignment3;


public class Base10Converter {
    public static int charToInteger(char digit) {
        return (int)digit - 48;
    }

    public static char integerToChar(int digit) {
        return (char)(digit + 48);
    }

    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static int arrayToInteger(char[] digits, int base, 
        boolean bigEndian) {

        int value = 0;
        int power = bigEndian ? digits.length - 1 : 0;
        int step = bigEndian ? -1 : 1;

        for(int i=0; i<digits.length; i++) {
            int digit = charToInteger(digits[i]);
            int raiseBase = (int)Math.pow(base, power);
            power += step;
            int digitValue = digit * raiseBase;
            value += digitValue;
        }

        return value;
    }

    public static char[] integerToArray(int value, int base, 
        boolean bigEndian) {
        char[] digits = new char[(int)(log(value, base) + 1)];
        int index = bigEndian ? digits.length - 1 : 0;
        int step = bigEndian ? -1 : 1;

        while(value > 0) {
            int remainder = value % base;
            char digitChar = integerToChar(remainder);
            digits[index] = digitChar;
            index += step;
            value = value / base;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(arrayToInteger("10101".toCharArray(), 2, true));
        System.out.println(arrayToInteger("11001".toCharArray(), 2, true));
        System.out.println(arrayToInteger("1234".toCharArray(), 4, true));
        System.out.println(arrayToInteger("4330".toCharArray(), 4, true));
        System.out.println(arrayToInteger("5467".toCharArray(), 8, true));
        System.out.println(arrayToInteger("1024".toCharArray(), 8, true));
        // System.out.println(arrayToInteger("7987".toCharArray(), 16, true));
        // System.out.println(arrayToInteger("AF23".toCharArray(), 16, true));
        System.out.println("**********");
        System.out.println(arrayToInteger("10101".toCharArray(), 2, false));
        System.out.println(arrayToInteger("11001".toCharArray(), 2, false));
        System.out.println(arrayToInteger("1234".toCharArray(), 4, false));
        System.out.println(arrayToInteger("4330".toCharArray(), 4, false));
        System.out.println(arrayToInteger("5467".toCharArray(), 8, false));
        System.out.println(arrayToInteger("1024".toCharArray(), 8, false));

        System.out.println("**********");
        System.out.println(integerToArray(1, 2, true));
        System.out.println(integerToArray(8, 2, true));
        System.out.println(integerToArray(15, 2, true));
        System.out.println(integerToArray(1024, 8, true));

        System.out.println("**********");
        System.out.println(integerToArray(1, 2, false));
        System.out.println(integerToArray(8, 2, false));
        System.out.println(integerToArray(15, 2, false));
        System.out.println(integerToArray(1024, 8, false));
        

    }
}
