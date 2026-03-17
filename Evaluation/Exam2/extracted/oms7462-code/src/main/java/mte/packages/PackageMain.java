package mte.packages;

import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.println("=========");
        // Part 1 - Packages in priority order
        Collections.sort(packages);
        System.out.println("Priority order: ");
        for(Package pkg : packages){
            System.out.println(pkg);
        }


       System.out.println("=========");
    
        //Part 2 - Packages in priority, length (increasing) order
        Collections.sort(packages,new TruckComparator());
        System.out.println("Priority, Length order: ");
        for(Package pkg : packages){
            System.out.println(pkg);
        }        

        System.out.println("=========");

        //Part 3 - Packages in priority, weight (decreasing) order
        Collections.sort(packages,new PlaneComparator());
        System.out.println("Priority, Weight order: ");
        for(Package pkg : packages){
            System.out.println(pkg);
        }

        System.out.println("=========");
        
        //Part 4 - PackageCollection
        //setup package collection object
        PackageCollection pkgCollection = new PackageCollection();
        for(Package pkg : packages) {
            pkgCollection.addPackage(pkg);
        }

        //Ensure that you can iterate throug the package collection
        for(Package pkg : pkgCollection){
            System.out.println(pkg);
        }

    }
    
}
