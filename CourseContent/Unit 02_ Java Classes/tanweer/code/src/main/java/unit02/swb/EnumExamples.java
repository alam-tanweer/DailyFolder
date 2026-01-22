package unit02.swb;

import java.util.Arrays;

public class EnumExamples {
    public static void main(String[] args) {

        // for(DamageType dt : values){
        //     System.out.println(dt);
        // }

       
        System.out.println(DamageType.HEAVY); // default to toString()
        System.out.println(DamageType.HEAVY.name());   //String
        System.out.println(DamageType.HEAVY.getColor()); //Attribute value

        // You will get error if string is not 
        DamageType dt2 = DamageType.valueOf("HEAVY"); //From a string value, get enum type

        DamageType[] values = DamageType.values();  //get all values.
        System.out.println(Arrays.toString(values)); // internally calls tostring for all values.


    }
}
