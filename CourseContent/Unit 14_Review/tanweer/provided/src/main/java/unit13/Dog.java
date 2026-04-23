package unit13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dog {
    private int age;
    private String name;
    private String breed;

    public static class AgeComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog dog1, Dog dog2) {
            return dog1.age - dog2.age;
        }
    }
    
// comment
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        Collections.sort(dogs, new AgeComparator());

        Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.age - dog2.age;
            }
        });

        Collections.sort(dogs, (dog1, dog2) -> dog1.age - dog2.age);
        
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }
    
}
