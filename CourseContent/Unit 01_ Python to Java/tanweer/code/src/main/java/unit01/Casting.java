package unit01;

public class Casting {
    public static void main(String[] args) {
        int a = 5;
        long b = (long)a;
        System.out.println("int to long: " + a + ", " + b);

        long c = 3000000001l;
        int d = (int)c;
        System.out.println("long to int: " + c + ", " + d);

        char e = 'a';
        int f = (int)e;
        System.out.println("char to int: " + e + ", " + f);

        int g = 124;
        char h = (char)g;
        System.out.println("int to char: " + g + ", " + h);

        float fl = (float)12.3;

        int in = 130;
        byte by = (byte)in;
        System.out.println("output" + by);
        
        // boolean i = false;
        // int j = (int)i;
        // System.out.println("boolean to int: " + i + ", " + j);

    }
}
