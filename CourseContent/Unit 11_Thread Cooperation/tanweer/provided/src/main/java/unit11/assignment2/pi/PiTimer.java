package unit11.assignment2.pi;

import org.apfloat.Apfloat;

public class PiTimer {
    private static final long NUM_TERMS = 10000;
    private static final long PRECESION = 100000;

    private static void timeCalculation (PiCalculator calculator, long numTerms) {
        long start = System.currentTimeMillis ();
        Apfloat pi = calculator.calculate (numTerms);
        long end = System.currentTimeMillis ();

        //System.out.println ("PI = " + pi.toString (true));
        System.out.println ("It took " + (end - start) / 1000.0 + 
            " seconds to calculate PI to " + NUM_TERMS + " terms.");
        System.out.println ("Got " + PiMillion.countCorrect (pi.toString (true)) +
            " terms correct.");
    }    

    private static final String pi = "3.14159265358979323846264338327950288419766380404548375908957770687844566385810717217984862822158914980889648130616832570860734466363474592379547409140088564763564015958758340420762905833102866646782745343526145097021077134410594954887738023084350443750591972086248405882504890331308828316637371145211590173685589493002395749035246147244122113104343152905297846650679169227320438368950845472227963343434175701462632304811317331787948481296040885903250811671778912367548111129341985460251063992491557671357296446857192698352371755336172453336986081958213638747890504962436708856405399625135849632860742579779021187064014995652797061995509725165727712851665155052653657850750654784237742953055844517914174796978217410042023219850513545757595720325097847888015594014146411981989255987748211755476754678800247117858088871771936904041008239798507518249229556348639942010589752720963524244121207977613524379402488342486096276144239649699516531076532271067682969796971985182338273319059248950865485176";

    private static final String bigPi;
    static {
        StringBuilder builder = new StringBuilder();
        for(String s : PiMillion.pi) {
            builder.append(s);
        }
        bigPi = builder.toString();
    }

    public static void main(String[] args) {
        // timeCalculation (new STCalculator (new RamanujanTermCalculator (PRECESION)), NUM_TERMS);
        timeCalculation (new MTCalculator(new RamanujanTermCalculator(10000)), 1000);
        timeCalculation (new MTChunkCalculator(new RamanujanTermCalculator(10000)), 1000);

        for(int i=0; i<pi.length(); i++) {
            if(pi.charAt(i) != bigPi.charAt(i)) {
                System.out.println("first mismatch at " + i);
                break;
            }
        }
    }
}
