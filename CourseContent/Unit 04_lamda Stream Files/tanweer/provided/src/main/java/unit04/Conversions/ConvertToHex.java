package unit04.Conversions;

public class ConvertToHex implements Conversion{
    @Override
    public String convert(int value) {
        return Integer.toHexString(value);
    }
}
