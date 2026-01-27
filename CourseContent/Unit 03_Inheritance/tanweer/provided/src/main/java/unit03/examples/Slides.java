package unit03.examples;

@SuppressWarnings("unused")
public class Slides {
    public enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
    }

    public static class Parent {
        private int x;

        public Parent(int x) {
            this.x = x;
        }
    }

    public static class Child extends Parent {
        private double y;

        public Child(int x, double y) {
            super(x);
            this.y = y;
        }
    }

    public static class Animal {
        private String name;
        private double weight;
      
        public Animal(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }
        
        public String toString() {
          return "Animal[name=" + name + ", weight=" + weight + "]";
        }
      
        public String getName() {
          return name;
        } 
      
        public double getWeight() {
            return weight;
        }

        public void greet(Animal o) {
          System.out.println(name + " greets " + o.name + "!"); 
        }
    }

    public static class Rabbit extends Animal {
        // fields, constructors, and methods are not
        // shown for brevity
        private String furColor;
      
        public Rabbit(double weight, String furColor) {
            super("Rabbit", weight);
            this.furColor = furColor;
        }
        
        public void move() {
          System.out.println(super.getName() + 
            " goes hop, hop, hop!");
        }  

        @Override
        public String toString() {
            return "Rabbit[name=" + getName() 
                + ", weight=" + getWeight()
                + ", fur color=" + furColor + "]";
        }
    }

    public static void main(String[] args) {
        DayOfWeek day = null;
        day = DayOfWeek.SATURDAY;

        Rabbit r = new Rabbit(2.5, "brown");
        Animal a = new Rabbit(3, "white");

        a.greet(r);
    }
}

