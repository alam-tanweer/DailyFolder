package mte.packages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PackageMain  {

    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();
        packages.add(new Package(Priority.LOW,22,15));
        packages.add(new Package(Priority.HIGH,13,17));
        packages.add(new Package(Priority.LOW,12,10));
        packages.add(new Package(Priority.MEDIUM,25,18));
        packages.add(new Package(Priority.MEDIUM,18,12));
        packages.add(new Package(Priority.LOW,14,25));
        packages.add(new Package(Priority.HIGH,10,7));

        // Part 1 - Packages in priority order
        
        // Comparable<Priority> comparable = new Comparable<Priority>() {

        //     @Override
        //     public int compareTo(Priority o) {
                
        //       return this.getRank() -  o.getRank();
        //     }
            
        // };
           // Collections.sort(packages);

        System.out.println("Priority order: " + packages);
        System.out.println();
        Comparator<Priority> comparator = new Comparator<Priority>() {

            @Override
            public int compare(Priority o1, Priority o2) {
              Package pol = new Package(o2, 0, 0);
              Package ptl = new Package(o2, 0, 0);
              return pol.getLength() - ptl.getLength();

            }
            
        };
    
        //Part 2 - Packages in priority, length (increasing) order
        // Collections.sort(packages); // <== Update or Modify this line to sort as per requirement.

        System.out.println("Priority, Length order: " + packages);
        System.out.println();

        //Part 3 - Packages in priority, weight (decreasing) order
        // Collections.sort(packages);   // <== Update or Modify this line to sort as per requirement.
        Comparator<Priority> comparator = new Comparator<Priority>() {

            @Override
            public int compare(Priority o1, Priority o2) {
              Package pol = new Package(o2, 0, 0);
              Package ptl = new Package(o2, 0, 0);
              return pol.getWeight() - ptl.getWeight();

            }
            
        };
        System.out.println("Priority, Weight order: " + packages);
        System.out.println();


        //Part 4 - PackageCollection
        //setup package collection object
        PackageCollection pkgCollection = new PackageCollection();
        for(Package pkg : packages) {
            pkgCollection.addPackage(pkg);
        }

        // //Ensure that you can iterate throug the package collection
        // for(Package pkg : pkgCollection){
        //     System.out.println(pkg);
        // }

    }

    //@Override
   // public int compareTo(Priority o) {
   //     // TODO Auto-generated method stub
   //     throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
   // }

    @Override
    public int compare(Priority o1, Priority o2) {
      return 
    }

  
    
}
