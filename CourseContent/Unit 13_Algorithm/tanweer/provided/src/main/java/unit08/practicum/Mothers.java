package unit08.practicum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mothers {
    public static List<String> mother(Graph<String> graph, List<String> values) {
        List<String> mothers = new ArrayList<>();
        
        for(int i=0; i<values.size(); i++) {
            String start = values.get(i);
            boolean found = true;
            for(int j=0; found && j<values.size(); j++) {
                if(i == j) {
                    continue;
                } else {
                    String end = values.get(j);
                    found = graph.bfSearch(start, end);
                }
            }
            if(found) {
                mothers.add(start);
            }
        }
        
        return mothers;
    }

    public static void main(String[] args){
        Graph<String> graph1 = new AdjacencyGraph<>();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";

        graph1.add(a);
        graph1.add(b);
        graph1.add(c);
        graph1.add(d);
        graph1.add(e);

        graph1.connectDirected(a, b);
        graph1.connectDirected(b, e);
        graph1.connectDirected(e, a);
        graph1.connectDirected(b, c);
        graph1.connectDirected(c, d);

        List<String> mothers1 = mother(graph1, Arrays.asList(a, b, c, d, e));
        System.out.println(mothers1);


        Graph<String> graph2 = new AdjacencyGraph<>();
        String t = "T";
        String u = "U";
        String v = "V";
        String w = "W";
        String x = "X";
        String y = "Y";
        String z = "Z";

        graph2.add(t);
        graph2.add(u);
        graph2.add(v);
        graph2.add(w);
        graph2.add(x);
        graph2.add(y);
        graph2.add(z);

        graph2.connectDirected(t, v);
        
        graph2.connectDirected(w, t);
        
        graph2.connectDirected(x, t);
        graph2.connectDirected(x, u);

        graph2.connectDirected(y, w);
        graph2.connectDirected(y, x);
        
        graph2.connectDirected(z, u);
        graph2.connectDirected(z, y);

        List<String> mothers2 = 
            mother(graph2, Arrays.asList(t, u, v, w, x, y, z));
        System.out.println(mothers2);
    }
}
