package unit03.activities;

public class Child extends Parent {
    private int age;

    public Child(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Child {name=" + getName() + ", age=" + age + "}";
    }
}
