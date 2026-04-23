package finalexam.factory;

import java.util.ArrayList;
import java.util.List;

public class Packer implements Runnable{
    private final int id;
    private final Item item;
    private final int count;
    private final List<Item> box;
    private final List<Item> conveyorBelt;

    public Packer(int id,Item item,int count,List<Item> conveyorBelt) {
        this.id = id;
        this.item = item;
        this.count = count;
        this.box = new ArrayList<>(count);
        this.conveyorBelt = conveyorBelt;
    }

    public List<Item> getBox() {return box;}

    public int getId() {return id;}

    @Override
    public void run() {
        while (box.size() < count) {
            Item nextItem;
            synchronized(conveyorBelt) {
                while (conveyorBelt.size() == 0 || conveyorBelt.get(0) != item) {
                    try {
                        conveyorBelt.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                nextItem = conveyorBelt.remove(0);
                conveyorBelt.notifyAll();
            }

            box.add(nextItem);
            System.out.println("Packer " + id + " packed " + nextItem + ", now has " + box.size());
        }
    }
}
