package unit03.Example;

public class Parent {

    private String name;

    //First defined a default
    public Parent(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void info(){
        System.out.println("Parent Info : " + name);
    }

}
