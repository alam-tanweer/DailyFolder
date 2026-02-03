package unit04.practicum.courses;

public class Word {
    public static void main(String[] args) {
        WGraph<String> word = new WAdjacencyGraph<>();
        word.add("H");
        word.add("O");
        word.add("M");
        word.add("E");
        word.add("W");
        word.add("o");
        word.add("R");
        word.add("K");
     
        word.connect("H", "O", 1);
        word.connect("H", "M", 8);

        word.connect("O", "M", 1);
        word.connect("O", "E", 9);

        word.connect("M", "E", 1);
        word.connect("M", "W", 10);

        word.connect("E", "W", 1);
        word.connect("E", "o", 11);

        word.connect("W", "o", 1);
        word.connect("W", "R", 12);

        word.connect("o", "R", 1);
        word.connect("o", "K", 13);

        word.connect("R", "K", 1);
        word.connect("R", "H", 200);

        System.out.println(word.weight("H", "R"));

        System.out.println(word.dijkstrasPath("H", "K"));

    }
    
}
