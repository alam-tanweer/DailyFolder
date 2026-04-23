package unit13;

public abstract class AbstractShape implements Shape {
    private String name;
    
    public AbstractShape(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

