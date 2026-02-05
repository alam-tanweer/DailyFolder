package unit04.Conversions;

public class ConversionMain {

    public static class ConvertToBinary implements Conversion {
        @Override
        public String convert(int value) {
            return Integer.toBinaryString(value);
        }
    }

    public static void main(String[] args) {
        int daValue = 555;
        System.out.println(daValue);
        // Full Class
        String hex = new ConvertToHex().convert(daValue);
        System.out.println(hex);
        // Inner Class
        String bin = new ConversionMain.ConvertToBinary().convert(daValue);
        System.out.println(bin);
        // Anon class
        Conversion octConverter= new Conversion() {
            @Override
            public String convert(int value) {
                return Integer.toOctalString(value);
            }
        };
        String oct = octConverter.convert(daValue);
        System.out.println(oct);
        // Short lambda
        Conversion octLambda = (val) -> Integer.toOctalString(val);
        oct = octLambda.convert(daValue);
        System.out.println(oct);
        // Method Ref
        Conversion intMR = Integer::toString;
        String intStr = intMR.convert(daValue);
        System.out.println(intStr);
    }
}
