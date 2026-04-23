package unit13;

import java.util.Comparator;

public class CatComparator implements Comparator <Cat> {

    @Override
    public int compare(Cat one, Cat two) {
        int result = one.getFurColor().compareTo(two.getFurColor());

        if (result == 0) {
            // 5 - 10 = -5
            result = two.getEvilRating() - one.getEvilRating();
        }
        return result;
    }
}
  
