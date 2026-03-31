package unit11.assignment2.pi;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apfloat.Apfloat;

/**
 * The Ramanujan series for calculating Pi
 * 1     2√2     (4k)!(1103 + 26390k)
 * - =  ------ ∑ --------------------
 * π     9801        (k!)⁴ 396⁴ᵏ
 */
public class RamanujanTermCalculator implements PiTermCalculator {
    private final long precision;
    private final Apfloat ft;
    private final Apfloat st;
    private final Apfloat tt;
    private final Apfloat one;
    private final Apfloat denom;

    public RamanujanTermCalculator (long precision) {
        this.precision = precision;
        ft = new Apfloat (1103, precision);
        st = new Apfloat (26390, precision);
        tt = new Apfloat (396, precision);
        one = new Apfloat (1, precision);
        denom = new Apfloat (9801, precision);
    }

    private Apfloat fact (long num) {
        Apfloat value = one;
        if (num == 0) {
            return value;
        }
        for (long i = num; i > 0; i--) {
            value = value.multiply (new Apfloat (i, precision));
        }
        return value;
    }

    private Apfloat pow (Apfloat value, long exp) {
        Apfloat result = new Apfloat (1, precision);
        for (long i = 0; i < exp; i++) {
            result = result.multiply (value);
        }
        return result;
    }

    @Override
    public Apfloat calculateTerm (long n) {
        Apfloat apN = new Apfloat(n, precision); 
        Apfloat term = fact (4 * n).multiply (ft.add (st.multiply (apN)));
        return term.divide (pow (fact (n), 4).multiply(pow (tt, 4 * n)));
    }

    @Override
    public Apfloat finalAdjustment (Apfloat sum) {
        // Need to multiply by the factor [2sqrt(2)/9801] and then invert the 
        // sum.
        System.out.println(sum);
        BigDecimal two = new BigDecimal (2);
        Apfloat factor = new Apfloat (two.sqrt (new MathContext ((int)precision)));
        factor = factor.multiply (new Apfloat (2, precision)).divide (denom);
        return one.divide(factor.multiply (sum));

    }

    @Override
    public long getPrecision() {
        return precision;
    }
    
}
