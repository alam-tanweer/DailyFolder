package unit11.assignment1.banks;

public class Stock{
    private double value;
    private String name;

    public Stock(String name){
        this.name = name;
        this.value = 0.0;
    }

    public void buyStock(){
        this.value += .1;
    }

    public void sellStock(){
        this.value -= .1;
    }

    @Override
    public String toString(){
        return name + " is valued at " + value;
    }
}