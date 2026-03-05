package unit08.legacy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public interface Operation {
        public double execute (double left, double right);
    } 

    public static Operation getOperation (String operation) {
        if (operation.equals ("+")){
            return new Operation(){
                public double execute (double left, double right) {
                    return left + right;
                }
            };
        }
        else if (operation.equals ("-")) {
            return (left, right) -> left - right;
        }
        else if (operation.equals ("*")) {
            return (left, right) -> left * right;
        }
        else if (operation.equals ("/")) {
            return (left, right) -> left / right;
        }
        else if (operation.equals ("^")) {
            return Math::pow;
        }

        throw new UnsupportedOperationException (operation + "is not a supported operator.");
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        double right = 0;
        double left = 0;
        String op = null;
        while (true) {
            try {
                left = scan.nextDouble ();
                op = scan.next ();
                right = scan.nextDouble ();
                Operation operation = getOperation (op);
                System.out.println (left + " " + op + " " + right + " = " + operation.execute(left, right));
            } catch (InputMismatchException ime) {
                break;
            }
        }

        System.out.println ("Thank you for using little calculator");
        scan.close ();
    }
}
