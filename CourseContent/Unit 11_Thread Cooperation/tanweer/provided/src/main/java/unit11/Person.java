package unit11;

public class Person {
    private boolean bladderFull;
    
    public void use(Potty potty) {
        if(bladderFull) {
            potty.use();
            bladderFull = false;
        }
    }
}
