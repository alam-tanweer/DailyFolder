package unit08.practicum.binaryop;

public class BinaryOps {
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
        for (boolean a : bools) {
            for (boolean b : bools) {
                System.out.println("A: " + a
                                    + ", B: " + b
                                    + ", AND: " + and.compute(a,b)
                                    + ", OR: " + or.compute(a,b)
                                    + ", XOR: " + xor.compute(a,b));
            }
        }
    }
}
