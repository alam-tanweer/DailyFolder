package mte.midterm;

public abstract class Vehicle{
    private String name;
    private double rating;
    private double mpg;

    public Vehicle (String name, double milesDriven, double gallonsUsed){
        this.name = name;
        this.rating = 0;
        mpg = milesDriven/gallonsUsed;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getMpg() {
        return mpg;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateFuelEfficiency();

    @Override
    public String toString() {
        return "Vehicle name: "+getName()+"\nFuel Efficiency: "+getRating();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle k){
            return (k.getName().equals(this.getName())&&k.getRating()==this.getRating());
        }
        else return false;
    }
}
