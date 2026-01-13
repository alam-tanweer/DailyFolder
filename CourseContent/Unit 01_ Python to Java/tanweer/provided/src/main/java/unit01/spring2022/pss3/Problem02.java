package unit01.spring2022.pss3;

public class Problem02 {
    public static int charToInteger(char digit) {
        return (int)digit - 48;
    }

    public static int stringToInt(String number, int base) {
        int value = 0;
        int power = number.length() - 1;
        char[] digits = number.toCharArray();

        for(int i=0; i<digits.length; i++) {
            int digit = charToInteger(digits[i]);
            int raiseBase = (int)Math.pow(base, power);
            power--;
            int digitValue = digit * raiseBase;
            value += digitValue;
        }

        return value;
    }
}
