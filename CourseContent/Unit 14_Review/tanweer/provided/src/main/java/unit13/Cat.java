package unit13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Comparable <Cat>{
    private String name;
    private String furColor;
    private int evilRating;

    public Cat (String name, String furColor, int evilRating) {
        this.name = name;
        this.furColor = furColor;
        this.evilRating = evilRating;
    }

    @Override
    public int compareTo (Cat cat) {
        return this.name.compareTo (cat.name);
    }

    public int getEvilRating() {
        return evilRating;
    }

    public String getFurColor() {
        return furColor;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<Cat> myCats = new ArrayList<>();
        Collections.sort (myCats);
    }
}
  
