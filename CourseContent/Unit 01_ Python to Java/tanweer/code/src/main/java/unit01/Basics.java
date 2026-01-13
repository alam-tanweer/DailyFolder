package unit01;

public class Basics {
    public static void main(String[] args) {
        for(int i=1; i<=100; i++) {
            // if(i % 3 == 0 && i % 7 != 0) { // challenge
            //     System.out.println(i);
            // } else if(i % 7 == 0 && i % 3 != 0) { // challenge
            //     System.out.println(i);
            // }

            //Multiple of 3 or 7
            if(i % 3 == 0 || i % 7 == 0) { // challenge
                //Not Multiple of 3 or 7
                if(!(i % 3 == 0 && i % 7 == 0)){ //Challenge
                    System.out.println(i);
                }
            }     
        }
    }
}
