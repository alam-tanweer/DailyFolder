package unit06.practicum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E>{
    private final static int INIT_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public ArrayStack() {
        elements = new Object[INIT_CAPACITY];
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements,size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E top() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        E value = (E)elements[size - 1];
        return value;
    }

    @Override
    public void push(E value) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements,elements.length * 2);
        elements[size] = value;
        ++size;
    }

    @Override
    public E pop() {
        if (size == 0)
            throw new NoSuchElementException("Stack is empty");
        --size;
        @SuppressWarnings("unchecked")
        E value = (E)elements[size];
        elements[size] = null;
        return value;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = size - 1;i >= 0;--i) {
            s += elements[i];
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }

    public static void main(String[] args) {
        int numLetters = 10;
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0;i < numLetters;++i) {
            char c = (char)('A' + i);
            stack.push(c);
            System.out.println("push: " + c + " " + stack);
        }
        System.out.println("toString: " + stack);

        System.out.println("top: " + stack.top());

        System.out.print("Iterator: ");
        for (char c : stack)
            System.out.print(c + " ");
        System.err.println();

        for (int i = 0;i < numLetters + 1;++i)
            System.out.println("Pop: " + stack.pop() + " " + stack);
        
    }
    
}
