package unit03.Example;

public class Child extends Parent {

    public Child(String name){
        super(name);
    }

    public void run(){
        System.out.println("Child running");
    }

    @Override
    public void info() {

        // TODO Auto-generated method stub
        // super.info();
        //can use super or this to access parent method. if parent also have it. then call super
        System.out.println("Child Info : " + this.getName());
    }
}
