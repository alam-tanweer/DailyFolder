package finalexam.factory;

import java.util.List;

public class Builder implements Runnable {
    private final int id;
    private final Item item;
    private final int count;
    private final List<Item> conveyorBelt;

    public Builder(int id,Item item,int count,List<Item> conveyorBelt) {
        this.id = id;
        this.item = item;
        this.count = count;
        this.conveyorBelt = conveyorBelt;
    }

    @Override
    public void run() {
        for (int i = 0;i < count;++i) {
            synchronized(conveyorBelt) {
                conveyorBelt.add(item);
                conveyorBelt.notifyAll();
            }
            System.out.println("Builder " + id + " added " + item);
        } 
    }
}
