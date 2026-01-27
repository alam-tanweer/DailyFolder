package unit03.assignment2.animals;
import java.util.Arrays;

public abstract class SocialAnimal implements Animal{
    private String name;
    private SocialAnimal friend1, friend2;

    public SocialAnimal(String name, SocialAnimal friend1, SocialAnimal friend2){
        this.name = name;
        this.friend1 = friend1;
        this.friend2 = friend2;
    }
    public SocialAnimal(String name){
       this(name, null, null);
    }
    public String getName(){ 
        return name;
    }
    public void setFriend1(SocialAnimal friend1){
        this.friend1 = friend1;
    }
    public void setFriend2(SocialAnimal friend2){
        this.friend2 = friend2;
    }
    public abstract void talkTo(SocialAnimal animal);
   
    public void spreadRumor(){
        this.talkTo(friend1);
        this.talkTo(friend2);

        if(friend1 != null){
            friend1.spreadRumor();
        }
        if(friend2 != null){
            friend2.spreadRumor();
        }

    }

    public void hear(Animal[] animals){ 
        int length = animals.length;
        if(animals!= null && animals.length > 0){
            Animal[] rest = Arrays.copyOfRange(animals, 0, length-1);
            animals[length-1].hear(rest);
            System.out.println(name + " hears " +  animals[length-1].makeSound()); 
        }  
    }

    @Override
    public String toString(){ 
        return getName() + " [" + makeSound() +"]";
    }
}
