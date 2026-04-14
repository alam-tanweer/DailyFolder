package unit08.practicum;

import java.util.List;

public class SixDegrees {
    public static void main(String[] args){
        Graph<String> graph = new AdjacencyGraph<>();
        
        // Wandavision
        String wandaVision = "WandaVision";
        graph.add(wandaVision);
        
        String olsen = "Elizabeth Olsen";
        graph.add(olsen);
        graph.connectUndirected(wandaVision, olsen);

        String bettany = "Paul Bettany";
        graph.add(bettany);
        graph.connectUndirected(wandaVision, bettany);

        String pCameron = "Peter Cameron";
        graph.add(pCameron);
        graph.connectUndirected(wandaVision, pCameron);

        String hahn = "Kathryn Hahn";
        graph.add(hahn);
        graph.connectUndirected(wandaVision, hahn);


        // Carnival Row
        String carnivalRow = "Carnival Row";
        graph.add(carnivalRow);
        graph.connectUndirected(carnivalRow, pCameron);

        String bloom = "Orlando Bloom";
        graph.add(bloom);
        graph.connectUndirected(carnivalRow, bloom);

        String delevingne = "Cara Delevingne";
        graph.add(delevingne);
        graph.connectUndirected(carnivalRow, delevingne);
        
        String mcBurney = "Simon McBurney";
        graph.add(mcBurney);
        graph.connectUndirected(carnivalRow, mcBurney);


        // Godzilla
        String godzilla = "Godzilla";
        graph.add(godzilla);
        graph.connectUndirected(godzilla, olsen);

        String taylor = "Aaron Taylor-Johnson";
        graph.add(taylor);
        graph.connectUndirected(godzilla, taylor);

        String adams = "CJ Adams";
        graph.add(adams);
        graph.connectUndirected(godzilla, adams);

        String watan = "Ken Watanabe";
        graph.add(watan);
        graph.connectUndirected(godzilla, watan);


        // Inception
        String inception = "Inception";
        graph.add(inception);
        graph.connectUndirected(inception, watan);

        String dicaprio = "Leonardo DiCaprio";
        graph.add(dicaprio);
        graph.connectUndirected(inception, dicaprio);        
        
        String levitt = "Joseph Gordon-Levitt";
        graph.add(levitt);
        graph.connectUndirected(inception, levitt);

        String page = "Elliot Page";
        graph.add(page);
        graph.connectUndirected(inception, page);


        // Umbrella Academy
        String umbrella = "Umbrella Academy";
        graph.add(umbrella);
        graph.connectUndirected(umbrella, page);

        String hopper = "Tom Hopper";
        graph.add(hopper);
        graph.connectUndirected(umbrella, hopper);

        String sheehan = "Robert Sheehan";
        graph.add(sheehan);
        graph.connectUndirected(umbrella, sheehan);

        String lampman = "Emmy Raver-Lampman";
        graph.add(lampman);
        graph.connectUndirected(umbrella, lampman);


        List<String> pageToOlsen = graph.bfPath(page, olsen);
        System.out.println(pageToOlsen);

        List<String> sheehanToWatan = graph.bfPath(sheehan, watan);
        System.out.println(sheehanToWatan);
        
        List<String> hopperToBurney = graph.bfPath(hopper, mcBurney);
        System.out.println(hopperToBurney);

        List<String> bloomToBettany = graph.bfPath(bloom, bettany);
        System.out.println(bloomToBettany);
    }
}
