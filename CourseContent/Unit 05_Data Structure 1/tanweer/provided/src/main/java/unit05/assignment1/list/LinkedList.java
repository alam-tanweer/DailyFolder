package unit05.assignment1.list;

import unit05.List;
import unit05.Node;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            append(list.get(i));
        }
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
    public String toString() {
        String result = "[";
        if (size() > 0) {
            Node<E> node = head;
            result += head.getValue();
            node = node.getNext();
            while (node != null) {
                result += "," + node.getValue();
                node = node.getNext();
            }
        }
        result += "]";
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList) {
            LinkedList<E> otherList = (LinkedList<E>) obj;
            if (this.size() == otherList.size()) {
                for (int i = 0; i < size(); i++) {
                    if (!get(i).equals(otherList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}