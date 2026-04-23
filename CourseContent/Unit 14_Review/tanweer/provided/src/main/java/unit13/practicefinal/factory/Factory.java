package finalexam.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {

    public static void main(String[] args) {
        int countOfEachItem = 10;

        List<Item> conveyorBelt = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();
        Map<Item,Packer> packers = new HashMap<>();

        int id = 0;
        for (Item item : Item.values()) {
            Thread thread = new Thread(new Builder(id,item,countOfEachItem,conveyorBelt));
            thread.start();
            threads.add(thread);
            ++id;

            Packer packer = new Packer(id,item,countOfEachItem,conveyorBelt);
            thread = new Thread(packer);
            thread.start();
            threads.add(thread);
            packers.put(item,packer);
            ++id;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Item item : packers.keySet()) {
            Packer packer = packers.get(item);
            List<Item> box = packer.getBox();
            System.out.println("Packer " + packer.getId() + " box: " + box);
            if (box.size() != countOfEachItem) {
                System.out.println("Error: Expected box size to be " + countOfEachItem + ", but was " + box.size());
            }
            else {
                for (Item boxItem : box) {
                    if (boxItem != item) {
                        System.out.println("Error: Expected item to be " + item + ", but was " + boxItem);
                    }
                }
            }
        }
    }
}
