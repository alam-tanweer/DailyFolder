package unit05.gen;

import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> node;

    public NodeIterator(Node<E> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public E next() {
        E element = node.getValue();
        node = node.getNext();
        return element;
    }
}
