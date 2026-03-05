package unit08.practicum.primes;

public class LogicCircuit {
    public interface UnaryGate {
        public boolean compute(boolean input);
    }

    public interface BinaryGate {
        public boolean compute(boolean input1,boolean input2);
    }

    public static void main(String[] args) {
        UnaryGate not = i -> !i;

        BinaryGate and = new BinaryGate() {
            @Override
            public boolean compute(boolean input1, boolean input2) {
                return input1 && input2;
            }
        };

        BinaryGate or = Boolean::logicalOr;

        boolean[] bools = {true,false};
        String sf = "%-5s|%-5s|%-5s|%-5s";
        System.out.println(String.format(sf,"A","B","C","D"));
        for (boolean a : bools) {
            for (boolean b : bools) {
                boolean c = or.compute(a,b);
                boolean d = not.compute(c);
                System.out.println(String.format(sf,a,b,c,d));
            }
        }

        System.out.println();

        sf = "%-5s|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s";
        System.out.println(String.format(sf,"A","B","C","D","E","F","G","H"));
        for (boolean a : bools) {
            for (boolean b : bools) {
                for (boolean c : bools) {
                    boolean d = or.compute(a,b);
                    boolean e = not.compute(c);
                    boolean f = not.compute(d);
                    boolean g = and.compute(d,e);
                    boolean h = or.compute(f,g);

                    System.out.println(String.format(sf,a,b,c,d,e,f,g,h));
                }
            }
        }
    }
}
