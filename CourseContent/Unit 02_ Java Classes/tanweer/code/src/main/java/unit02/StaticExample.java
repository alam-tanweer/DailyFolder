package unit02;

public class StaticExample {
    public static void main(String[] args) {
        Human redCar = new Human("RUNNING");
        Human blueCar = new Human("STOPPED");
        Human greenCar = new Human("DEAD");

        System.out.println("RED : " + redCar.getState());
        System.out.println("Blue : " + blueCar.getState());
        System.out.println("greem : " + greenCar.getState());
    }
}
