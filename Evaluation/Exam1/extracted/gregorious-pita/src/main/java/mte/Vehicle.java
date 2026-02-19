package mte;

public abstract class Vehicle {
    public String name;
    public double mpg;

    public Vehicle(String name, double mpg) {
        this.name = name;
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return name + ", " + mpg;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle other = (Vehicle) obj;
            if ((other.name.equals(this.name)) && (other.mpg == this.mpg)) { return true; }
            else { return false; }
        }
        else { return false; }
    }
}