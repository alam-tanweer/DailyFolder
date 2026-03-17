package mte.packages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageMain {

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
            Collections.sort(packages);

        System.out.println("Priority order: " + packages);
        System.out.println();
    
        //Part 2 - Packages in priority, length (increasing) order
        
        Collections.sort(packages, new lengthComparator()); // <== Update or Modify this line to sort as per requirement.

        System.out.println("Priority, Length order: " + packages);
        System.out.println();

        //Part 3 - Packages in priority, weight (decreasing) order
        Collections.sort(packages, new weightComparator());   // <== Update or Modify this line to sort as per requirement.

        System.out.println("Priority, Weight order: " + packages);
        System.out.println();


        //Part 4 - PackageCollection
        //setup package collection object
        // PackageCollection pkgCollection = new PackageCollection();
        // for(Package pkg : packages) {
        //     pkgCollection.addPackage(pkg);
        // }

        // //Ensure that you can iterate throug the package collection
        // for(Package pkg : pkgCollection){
        //     System.out.println(pkg);
        // }

    }
    
}
