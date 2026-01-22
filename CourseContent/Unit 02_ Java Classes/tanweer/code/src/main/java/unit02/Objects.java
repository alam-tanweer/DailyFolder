package unit02;

import java.util.Arrays;

public class Objects {

    public static Object[] funWithObjects(Object object) {
        Object[] array = new Object[5];

        array[0] = object.toString();
        array[1] = 123.456f;
        array[2] = new Year(1975);
        int[] ints = { 1, 2, 3, 5 };
        array[4] = ints;

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(funWithObjects("abcd")));
        System.out.println(Arrays.toString(funWithObjects(1234)));
        System.out.println(Arrays.toString(funWithObjects(new int[4])));
    }

}
