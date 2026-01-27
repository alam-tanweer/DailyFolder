package unit03.assignment2.animals;
public class Cat extends SocialAnimal{
    public Cat(String name){
        super(name);
    }
    public String makeSound(){
        return "meow";
    }   
    @Override
    public void talkTo(SocialAnimal animal){ 
        if(animal != null)
            System.out.println(getName() + " purrs " + makeSound() + " to " + animal.getName() +" with a big smile.");
    }
}
