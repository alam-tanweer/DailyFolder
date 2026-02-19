package mte;

public class Van extends Vehicle {
    private int passengers; 

    public Van( double erating, double passengers) {
        super("Vehicle", erating);
        this.erating = erating - passengers * 0.5;
       
    }

    @Override
    public String getName(){return name;}
    @Override
    public double getErating(){return erating;}

@Override
    public  String toString(){
        return "Van:  " + getName() + "Fuel Efficiency: " + getErating();
    }
        
    @Override
        public boolean equals(Object o) {
            // TODO Auto-generated method stub
            return super.equals(o);
        }

    
}
