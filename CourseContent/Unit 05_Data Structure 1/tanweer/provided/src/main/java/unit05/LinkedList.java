package unit05;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void append(E value) {
        Node<E> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.getNext();
            index--;
        }

        return current.getValue();
    }

    @Override
    public void set(int index, E value) {
        Node<E> current = head;
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        current.setValue(value);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<>(head);
    }

    // Below are the solutions to the extra credit problems for insert and remove

    // @Override
    // public void insert(int index, eleType value) {
    // Node<eleType> current = head;
    // int counter = index - 1;
    // while(counter > 0) {
    // current = current.getNext();
    // counter--;
    // }
    // Node<eleType> newNode = new Node<>(value);
    // if (index == 0){
    // newNode.setNext(head);
    // head = newNode;
    // } else {
    // newNode.setNext(current.getNext());
    // current.setNext(newNode);
    // }
    // if (index == size){
    // tail = newNode;
    // }
    // size++;
    // }

    // @Override
    // public eleType remove(int index) {
    // eleType result = null;
    // if (index == 0){
    // result = head.getValue();
    // head = head.getNext();
    // } else {
    // Node<eleType> current = head;
    // Node<eleType> last = current;
    // int counter = index;
    // while(counter > 0) {
    // last = current;
    // current = current.getNext();
    // counter--;
    // }
    // result = current.getValue();
    // last.setNext(current.getNext());
    // if (index == size -1 ) {
    // tail = last;
    // }
    // }
    // size--;
    // return result;
    // }

}
