package unit02.swb;

import java.util.Arrays;

public class EnumExamples {
    public static void main(String[] args) {
        DamageType[] values = DamageType.values();

        System.out.println(Arrays.toString(values));
        // for(DamageType dt : values){
        //     System.out.println(dt);
        // }

        System.out.println(DamageType.HEAVY);
        System.out.println(DamageType.HEAVY.getColor());
        System.out.println(DamageType.HEAVY.name());

        // You will get error.
        DamageType dt2 = DamageType.valueOf("HEAVY");

    }
}
