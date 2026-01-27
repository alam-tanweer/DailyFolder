package unit03.activities;

public class Family {
    public static void printParent(Parent parent) {
        System.out.println(parent);
    }

    public static void printChild(Child child) {
        System.out.println(child);
    }

    public static void main(String[] args) {
        Parent parent = new Parent("Papa Bear");
        Child child = new Child("Baby Bear", 2);

        printParent(parent);
        printParent(child);

        // printChild(parent); // compiler error
        printChild(child);

        Parent parentChild = (Parent)child;
        parentChild.getName();
        // parentChild.getAge(); // compiler error

        Child childParent = (Child)parent; // runtime error
        System.out.println(childParent);
    }
    
}
