package unit13.mvcpractice;

import java.util.HashSet;
import java.util.Set;

public class Model {
    private int count;

    private Set<ModelObserver> observers;

    public Model(){
        count = 0;
        observers = new HashSet<>();
    }

    public int getCount() {
        return count;
    }
    
    public void increment(){
        count=count + 2;
        System.out.println(count);
         // Notify view
        notifyObservers();
    }

    // Allow View to register to be notified
    public void register(ModelObserver observer){
        observers.add(observer);
    }

    // Notify view
    private final void notifyObservers(){
        for (ModelObserver o : observers){
            o.modelChanged(this);
        }

    }

}
