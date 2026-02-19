package unit05.mcf;

public class ForEach {

    /**
     * 4.3.2
     * 
     * @param array
     */
    public static void forArray(String[] array) {
        for(String element : array) {
            System.out.println(element);
        }
    }

    /**
     * 4.3.3
     * 
     * Initially will not compile becase List is not iterable.
     * 
     * @param list
     */
    public static void forList(List<String> list) {
        for(String element : list) {
            System.out.println(element);
        }
    }


    public static void main(String[] args) {
        String[] array = { "a", "b", "c" };
        // forArray(array);

        ArrayList<String> al = new ArrayList<>();
        al.append("A");
        al.append("B");
        al.append("C");
        al.append("D");

        // System.out.println(al);
        forList(al);
    }
}
