package unit08.assignment1.haunted;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import unit08.weighted.WAdjacencyGraph;
import unit08.weighted.WPath;

public class EscapeDA {
    private final static String BUILDING_FILE = "data/haunted/mansion.csv";
    private final static double HAUNTED_WEIGHT = 10000;
    private final static double SAFE_WEIGHT = 1;

    private static WAdjacencyGraph<Area> buildGraph(Map<Area,Collection<Area>> passages) {
        WAdjacencyGraph<Area> building = new WAdjacencyGraph<>();

        for (Area area : passages.keySet()) {
            if (building.contains(area) == false)
                building.add(area);

            Collection<Area> neighbors = passages.get(area);
            for (Area neighbor : neighbors) {
                if (building.contains(neighbor) == false)
                    building.add(neighbor);

                if (!building.connected(area,neighbor)) {
                    double weight;
                    if (!area.isHaunted() && !neighbor.isHaunted())
                        weight = SAFE_WEIGHT;
                    else 
                        weight = HAUNTED_WEIGHT;

                    building.connect(area,neighbor,weight);
                }
            }
        }
        return building;
    }

    public static void main(String[] args) {
        try {
            BuildingFileParser fileParser = new BuildingFileParser(BUILDING_FILE);
            WAdjacencyGraph<Area> building = buildGraph(fileParser.getPassages());

            Area start = fileParser.getStartArea();

            System.out.println("\nYou awake in the " + start 
                                + " and desperately need to find a way out!");

            System.out.println("\nHaunted Areas: ");
            for (Area a : fileParser.getHauntedAreas())
                System.out.println("\t" + a);

            WPath<Area> minPath = null;
            for (Area exit : fileParser.getExitAreas()) {
                WPath<Area> path = building.dijkstrasPath(start, exit);
                if (path.getDistance() < HAUNTED_WEIGHT) {
                    if (null == minPath)
                        minPath = path;
                    else if (path.getDistance() < minPath.getDistance())
                        minPath = path;
                }
            }

            System.out.println();
            
            if (null == minPath)
                System.out.println("There is no escape.  You will haunt the grounds for all eternity.");
            else {
                System.out.println("You found the shortest way out!");
                System.out.println(minPath);
                // String indent = "\t";
                // for (int i = 0;i < minPath.size();++i, indent += "\t")
                //     System.out.println(indent + minPath.get(i));
            }
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}
