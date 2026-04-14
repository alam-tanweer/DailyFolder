package unit08.assignment1.haunted;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class BuildingFileParser {
    private final static Random RNG = new Random();
    private Collection<Area> safeAreas;
    private Collection<Area> exitAreas;
    private Collection<Area> hauntedAreas;
    private Map<Area,Collection<Area>> passages;

    public BuildingFileParser(String filename) throws IOException {
        safeAreas = new HashSet<>();
        exitAreas = new HashSet<>();
        hauntedAreas = new HashSet<>();
        passages = new HashMap<>();
        parse(filename);
    }

    public Collection<Area> getSafeAreas() { return safeAreas; }
    public Collection<Area> getExitAreas() { return exitAreas; }
    public Collection<Area> getHauntedAreas() { return hauntedAreas; }
    public Map<Area,Collection<Area>> getPassages() { return passages; }

    public Area getStartArea() {
        Object[] a = safeAreas.toArray();
        return (Area)a[RNG.nextInt(safeAreas.size())];
    }

    private Area parseAreaFromString(String areaString,Map<String,Area> areas) {
        String[] tokens = areaString.split("-");

        String name = tokens[0];
        if (areas.containsKey(name)) {
            return areas.get(name);
        }
        else {
            AreaType type = AreaType.valueOf(tokens[1]);

            Area area = new Area(name,type);
            if (type == AreaType.EXIT)
                exitAreas.add(area);
            else {
                String evilPresence = EvilPresenceUtil.getRandomPresence();
                if (evilPresence == null)
                    safeAreas.add(area);
                else {
                    area.haunt(evilPresence);
                    hauntedAreas.add(area);
                }
            }

            areas.put(area.getName(),area);
            return area;
        }
    }

    private void parse(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Map<String,Area> areas = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] areaTokens = line.split(",");

                Area area = parseAreaFromString(areaTokens[0],areas);

                Set<Area> connectedAreas = new HashSet<>();
                passages.put(area,connectedAreas);

                for (int i = 1;i < areaTokens.length;++i) {
                    Area connectedArea = parseAreaFromString(areaTokens[i],areas);
                    connectedAreas.add(connectedArea);
                }
            }
        }
    }

    private String areasToString(String name,Collection<Area> areas) {
        String s = name;
        for (Area area : areas)
            s += "\n\t" + area;
        return s;
    }

    @Override
    public String toString() {
        String s = areasToString("Safe Areas:",safeAreas);
        s += "\n" + areasToString("Haunted Areas: ",hauntedAreas);
        s += "\n" + areasToString("Exit Areas: ",exitAreas);
        s += "\nPassages:";
        for (Area area : passages.keySet()) {
            s += "\n\t" + area + " -> " + passages.get(area);
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            BuildingFileParser buildingFileParser = new BuildingFileParser("data/haunted/mansion.csv");
            System.out.println(buildingFileParser);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}