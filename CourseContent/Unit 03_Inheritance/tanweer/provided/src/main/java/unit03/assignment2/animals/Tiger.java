package unit03.assignment2.animals;
import java.util.Arrays;

public class Tiger implements Animal{
    private int weight;

    public Tiger(int weight){
        this.weight = weight;
    }
    public String makeSound(){
        return "grrrrr";
    }
    @Override
    public String toString(){
       return weight + " lb tiger " + "[" + makeSound() + "]";
    }

    public void hear(Animal[] animals){ //this hears from animals
        int length = animals.length;
        if(animals!= null && animals.length > 0){
            Animal[] rest = Arrays.copyOfRange(animals, 0, length-1);
            animals[length-1].hear(rest);
            System.out.println("A tiger hears " +  animals[length-1].makeSound()); 
        }  
    }  
}
