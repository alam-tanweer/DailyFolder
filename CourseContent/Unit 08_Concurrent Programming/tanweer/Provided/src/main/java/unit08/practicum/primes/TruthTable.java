package unit08.practicum.primes;

public class TruthTable {
    public interface BinaryLogicalOp {
        public boolean compute(boolean a,boolean b);
    }

    public static void main(String[] args) {

        BinaryLogicalOp and = new BinaryLogicalOp() {
            @Override
            public boolean compute(boolean a, boolean b) {
                return a && b;
            }
        };

        BinaryLogicalOp or = Boolean::logicalOr;

        BinaryLogicalOp xor = (a,b) -> a ^ b;

        boolean[] bools = {false,true};
        String sf = "%-5s|%-5s|%-5s|%-5s|%-5s";
        System.out.println(String.format(sf,"A","B","AND","OR","XOR"));
        System.out.println("-----------------------------");
        for (boolean a : bools) {
            for (boolean b : bools) {
                boolean andOut = and.compute(a,b);
                boolean orOut = or.compute(a,b);
                boolean xorOut = xor.compute(a,b);
                System.out.println(String.format(sf,a,b,andOut,orOut,xorOut));
            }
        }
    }
}
