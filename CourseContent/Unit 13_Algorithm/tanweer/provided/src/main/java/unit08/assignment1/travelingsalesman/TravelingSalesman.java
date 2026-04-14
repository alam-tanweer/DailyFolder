package unit08.assignment1.travelingsalesman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import unit08.weighted.WAdjacencyGraph;
import unit08.weighted.WGraph;
import unit08.weighted.WPath;

public class TravelingSalesman {
    private static final String CITIES_FILE = "data/travelingsalesman/52cities.csv";
    public static List<City> readCities(String filename) throws IOException {
        try(FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr)) {
            List<City> cities = new LinkedList<>();

            reader.readLine(); // skip header
            String line = reader.readLine();
            while(line != null) {
                String[] record = line.split(",");
                String name = record[0];
                String state = record[1];
                double lat = Double.parseDouble(record[2]);
                double lng = Double.parseDouble(record[3]);
                City city = new City(name, state, lat, lng);
                cities.add(city);

                line = reader.readLine();
            }

            return cities;
        }
    }

    public static WGraph<City> makeGraph(List<City> cities) {
        WGraph<City> graph = new WAdjacencyGraph<>();
        for(City city : cities) {
            graph.add(city);
        }

        for(int i=0; i<cities.size(); i++) {
            City city = cities.get(i);
            for(int j=i+1; j<cities.size(); j++) {
                City neighbor = cities.get(j);
                graph.connect(city, neighbor, city.distanceFrom(neighbor));
            }
        }

        return graph;
    }


    public static void main(String[] args) throws IOException {
        List<City> cities = readCities(CITIES_FILE);

        WGraph<City> graph = makeGraph(cities);

        Map<String, City> cityMap = new HashMap<>();
        for(City city : cities) {
            cityMap.put(city.toString(), city);
        }

        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while(go) {
            System.out.print("Enter origin city: ");
            String originName = scanner.nextLine();
            System.out.print("Enter destination city: ");
            String destName = scanner.nextLine();

            if(originName.equals("") || destName.equals("")) {
                go = false;
            } else if(!cityMap.containsKey(originName)) {
                System.out.println(originName + " is not found. Try again.");
            } else if(!cityMap.containsKey(destName)) {
                System.out.println(destName + " is not found. Try again.");
            } else {
                City origin = cityMap.get(originName);
                City dest = cityMap.get(destName);
                WPath<City> path = graph.nearestNeighbor(origin, dest);
                System.out.println(path);
                System.out.println();
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
        
    }
}
