package unit03.activities;

public class Slides {
    public static void main(String[] args) {
        Parent par = new Parent("Anakin");
        Parent chi = new Child("Luke", 19);
        System.out.println(par);
        System.out.println(chi);
    }

    public abstract class AbstractParent {
        public abstract void aMethod();
    }

    public class ConcreteChild extends AbstractParent {
        @Override
        public void aMethod() {
            System.out.println("Hi!");
        }
    }
}
