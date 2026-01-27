package unit03.assignment2.toys.pss;

/**
 * THIS SHOULD BE IMPLEMENTED AS a Truck class!! Do not use this code verbatim.
 */
public class Problem04 {
    // ASSUME THAT THESE EXIST: NOT DIRECTLY USED IN PSS
    public class Product {

    }

    // PSS Solution (students are very unlikely to implement this entire class)
    public class Truck {
        private Product[] products;
        private int loaded;

        public Truck(int capacity) {
            this.products = new Product[capacity];
            this.loaded = 0;
        }

        public boolean isFull() {
            return loaded == products.length;
        }

        public boolean isEmpty() {
            return loaded == 0;
        }

        public void load(Product product) {
            if(!isFull()) {
                products[loaded] = product;
                loaded++;
            }
        }

        public Product unload() {
            if(!isEmpty()) {
                loaded--;
                Product product = products[loaded];
                products[loaded] = null;
                return product;
            } else {
                return null;
            }
        }
    }


}
