package unit11;

public class Personv2 {
    private boolean bladderFull;
    
    public void use(Pottyv2 potty) {
        if(bladderFull) {
            potty.getDoor().lock();
            try {
                potty.use();
            } finally {
                potty.getDoor().unlock();
            }
            bladderFull = false;
        }
    }
}
