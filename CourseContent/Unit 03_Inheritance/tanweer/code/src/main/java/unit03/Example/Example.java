package unit03.Example;

public class Example {
    public static void main(String[] args){

        Parent p = new Parent("Hi");
        Parent pc = new Child("Hello");
        
        print(new Child("xx"));

        //Try different methods about accessing 
        pc.info();

        // printChild(p);
    }

    public static void print(Parent p){
        //try accessing parent and child method.
    }

    public static void printChild(Child p){

    }    
}
