package unit07.assignment1.connected;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = new File("data");
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }
            Graph<String> graph = GraphReader.readGraph(file.getAbsolutePath());
            int count = graph.countConnectedComponents();
            System.out.println(file.getName() + " connection components: "
                    + count);
        }
    }
}
