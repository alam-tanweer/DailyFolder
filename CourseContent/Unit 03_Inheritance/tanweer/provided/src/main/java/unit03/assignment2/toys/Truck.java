package unit03.assignment2.toys;

public class Truck {
    private Product[] inventory;
    private int packed;
    
    public Truck(int capacity) {
        inventory = new Product[capacity];
        packed = 0;
    }

    public boolean isFull() {
        return packed == inventory.length;
    }

    public boolean isEmpty() {
        return packed <= 0;
    }

    public boolean load(Product product) {
        if(isFull()) {
            return false;
        } else {
            inventory[packed] = product;
            packed++;
            return true;
        }
    }

    public Product unload() {
        Product product = null;
        if(!isEmpty()) {
            packed--;
            product = inventory[packed];
            inventory[packed] = null;
        }
        return product;
    }
}
