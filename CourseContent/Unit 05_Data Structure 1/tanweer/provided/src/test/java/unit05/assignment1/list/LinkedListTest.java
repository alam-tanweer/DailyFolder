package unit05.assignment1.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit05.List;
import unit05.LinkedList;

public class LinkedListTest {
    @Test
    public void create() {
        // setup - none

        // invoke
        List<String> list = new LinkedList<>();

        // analyze
        assertEquals(0, list.size());
    }

    @Test
    public void append() {
        // setup
        List<String> list = new LinkedList<>();

        // invoke
        list.append("abc");

        // analyze
        assertEquals(1, list.size());
        assertEquals("abc", list.get(0));
    }

    @Test
    public void get() {
        // setup
        List<String> list = new LinkedList<>();
        list.append("abc");
        list.append("def");
        list.append("ghi");

        // invoke
        String actual = list.get(2);

        // analyze
        assertEquals("ghi", actual);
    }

    @Test
    public void getError() {
        try {
            List<String> list = new LinkedList<>();
            list.append("abc");
            String x = list.get(1);
            assertTrue(false);
            System.out.println(x);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

}