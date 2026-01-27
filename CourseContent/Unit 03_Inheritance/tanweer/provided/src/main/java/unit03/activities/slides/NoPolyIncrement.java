package unit03.activities;

public class NoPolyIncrement {
    private Constant constant;
    private Increment increment;
    private Decrement decrement;

    public NoPolyIncrement(Constant constant) {
        this.constant = constant;
        this.increment = null;
        this.decrement = null;
    }

    public NoPolyIncrement(Increment increment) {
        this.constant = null;
        this.increment = increment;
        this.decrement = null;
    }

    public NoPolyIncrement(Decrement decrement) {
        this.constant = null;
        this.increment = null;
        this.decrement = decrement;
    }

    public double evaluate() {
        if(constant != null) {
            return constant.evaluate() + 1;
        } else if(increment != null) {
            return increment.evaluate() + 1;
        } else {
            return decrement.evaluate() + 1;
        }
    }
}
