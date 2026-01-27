package unit03.assignment2.animals;
public class Dog extends SocialAnimal{
    public Dog(String name){
        super(name);
    }
    public String makeSound(){ // Animal
        return "woof";
    }
    @Override
    public void talkTo(SocialAnimal animal){ // SocialAnimal
        if(animal != null)
            System.out.println(getName() + " barks " + makeSound() + " to " + animal.getName() +" waving its tail.");
    }
}
