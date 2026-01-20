package unit02.examples;

public class Pet {
    private String name;
    private int age;

    public Pet (String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void birthday () {
        age++;
    }   

    @Override
    public String toString() {
        return "Pet{name=" + name
            + ", age=" + age
            + "}";
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Pet) {
            Pet p = (Pet)other;
            return this.name.equals(p.name) &&
                this.age == p.age;
        } else {
            return false;
        }
    }
}
