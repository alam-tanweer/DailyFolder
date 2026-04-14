package unit08.assignment2.haunted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import unit08.assignment1.haunted.Area;
import unit08.assignment1.haunted.AreaType;
import unit08.assignment1.haunted.BuildingFileParser;
import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;

public class EscapeBT implements Configuration<EscapeBT> {
    private final static String BUILDING_FILE = "data/haunted/mansion.csv";

    private final Map<Area,Collection<Area>> passages;
    private final Area currentArea;
    private final List<Area> escapePath;

    public EscapeBT(Map<Area,Collection<Area>> passages,Area currentArea) {
        this(passages,currentArea,new ArrayList<>());
    }

    private EscapeBT(Map<Area,Collection<Area>> passages,Area currentArea,
                                            List<Area>escapePath) {
        this.passages = passages;
        this.currentArea = currentArea;
        this.escapePath = new ArrayList<>(escapePath);
        this.escapePath.add(currentArea);
    }

    public List<Area> getEscapePath() {
        return escapePath;
    }

    @Override
    public Collection<EscapeBT> getSuccessors() {
        List<EscapeBT> successors = new ArrayList<>();
        for (Area area : passages.get(currentArea)) {
            if (escapePath.contains(area) == false) {
                List<Area> escapePathCopy = new ArrayList<>(escapePath);
                successors.add(new EscapeBT(passages,area,escapePathCopy));
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        return !currentArea.isHaunted();
    }

    @Override
    public boolean isGoal() {
        return currentArea.getType() == AreaType.EXIT;
    }

    @Override
    public String toString() {
        return escapePath.toString();
    }

    public static void main(String[] args) {
        try {
            BuildingFileParser fileParser = new BuildingFileParser(BUILDING_FILE);
            Collection<Area> hauntedAreas = fileParser.getHauntedAreas();
            Area start = fileParser.getStartArea();
            Map<Area,Collection<Area>> passages = fileParser.getPassages();

            System.out.println("\nYou awake in the " + start
                        + " and desperately need to find a way out!");

            System.out.println("\nHaunted Areas: ");
            for (Area a : hauntedAreas)
                System.out.println("\t" + a);
            System.out.println();

            EscapeBT initialConfig = new EscapeBT(passages,start);
            Backtracker<EscapeBT> backtracker = new Backtracker<>(false);
            EscapeBT solution = backtracker.solve(initialConfig);
            if (null == solution)
                System.out.println("There is no escape.  You will haunt the grounds for all eternity.");
            else {
                System.out.println("You have found a way out!");
                System.out.println(solution);
            }
        } catch(IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}
