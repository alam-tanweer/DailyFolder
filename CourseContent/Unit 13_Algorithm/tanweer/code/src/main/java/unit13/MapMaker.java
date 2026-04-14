package unit13;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import unit13.weighted.WAdjacencyGraph;
import unit13.weighted.WGraph;
import unit13.weighted.WPath;

public class MapMaker {
    public static WGraph<City> buildMap(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
            Scanner scanner = new Scanner(fr)) {
            WGraph<City> map = new WAdjacencyGraph<>();

            List<City> cities = new ArrayList<>();
            scanner.nextLine(); // skip header
            while (scanner.hasNext()) {
                String[] tokens = scanner.nextLine().split(",");
                String name = tokens[0];
                String state = tokens[1];
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);

                City city = new City(name, state, latitude, longitude);
                cities.add(city);
                map.add(city);
            }

            for (int i=0; i<cities.size(); i++) {
                for (int j=i+1; j<cities.size(); j++) {
                    City city1 = cities.get(i);
                    City city2 = cities.get(j);

                    map.connect(city1, city2, city1.distance(city2));
                }
            }

            return map;
        }
    }

    public static void main(String[] args) throws IOException {
        // WGraph<City> map = buildMap("data/travelingsalesman/onecityperstate.csv");
        WGraph<City> map = buildMap("data/uscities.csv");

        City city1 = new City("Boston", "Massachusetts", 42.3601, -71.0589);
        City city2 = new City("Los Angeles", "California" ,34.0522,-118.2437);

        // WPath<City> nnPath = map.nearestNeighbor(city1, city2);
        // for (int i=0; i<nnPath.size(); i++) {
        //     System.out.println(nnPath.get(i));
        // }
        // System.out.println("total distance: " + nnPath.getDistance());
        // System.out.println("************************************************");

        // WPath<City> dsPath = map.dijkstrasPath(city1, city2);
        // for (int i=0; i<dsPath.size(); i++) {
        //     System.out.println(dsPath.get(i));
        // }
        // System.out.println("total distance: " + dsPath.getDistance());
    }
}

