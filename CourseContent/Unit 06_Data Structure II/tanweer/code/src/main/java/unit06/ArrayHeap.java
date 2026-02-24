package unit06;

import java.util.Arrays;

//6.16
public class ArrayHeap implements Heap{
    private int[] array;
    private int size;

    public ArrayHeap() {
        array = new int[5];
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return size + ", " + Arrays.toString(array);
    }


    @Override
    public void add(int value) {
        if (size == array.length){
            array = Arrays.copyOf(array, size * 2);
        }

        array[size] = value;

        //shifting up
        int child = size;
        int parent = (child -1)/2;
        while(array[parent] > array[child]){
            System.out.println("Before swap: " + Arrays.toString(array));    
            swap(parent,child);
            child = parent;
            parent = (child -1)/2;    
            System.out.println("After swap: " + Arrays.toString(array));        
        }
        System.out.println("Loop done");

        size++;

    }

    private void swap(int a, int b) {
        if(a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    @Override
    public int remove() {
        int temp = array[0];
        size--;
        swap(0,size);
        array[size] = 0;

        //Shifting down
        int parent = 0;

        while(parent < size){
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int dest = parent;

            if (left < size && array[left] < array[parent]){
                dest = left;
            }
            if (right < size && array[right] < array[left]){
                dest = right;
            }
            if (array[dest] < array[parent]){
                swap(dest,parent);
                parent = dest;
            } else {
                break;
            }
        }

        return temp;
    }
    
    public static void main(String[] args) {
        Heap heap = new ArrayHeap();

        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);

        heap.remove();
        System.out.println("output: " + heap);        
        heap.remove();
        System.out.println("output: " + heap);
    }
}
