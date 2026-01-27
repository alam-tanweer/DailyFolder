package unit03.assignment2.thegame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HandTest {
    @Test
    public void create() {
        // setup
        int size = 2;
        String string = "[]";

        // invoke
        Hand hand = new Hand(size);

        // analyze
        assertEquals(string, hand.toString());
        assertTrue(hand.isEmpty());
        assertFalse(hand.isFull());
    }

    @Test
    public void dealOne() {
        // setup
        int size = 2;
        int card = 5;
        String string = "[5]";
        Hand hand = new Hand(size);

        // invoke
        hand.deal(card);

        // analyze
        assertEquals(string, hand.toString());
        assertFalse(hand.isEmpty());
        assertFalse(hand.isFull());
    }

    @Test
    public void dealTwo() {
        // setup
        int size = 2;
        int card1 = 3;
        int card2 = 7;
        String string = "[3, 7]";
        Hand hand = new Hand(size);

        // invoke
        hand.deal(card1);
        hand.deal(card2);

        // analyze
        assertEquals(string, hand.toString());
        assertFalse(hand.isEmpty());
        assertTrue(hand.isFull());
    }

    @Test
    public void dealFull() {
        // setup
        Hand hand = new Hand(1);
        hand.deal(3);

        // invoke
        boolean dealt = hand.deal(10);
        
        // analyze
        assertTrue(hand.isFull());
        assertFalse(dealt);
    }

    @Test
    public void removeEmpty() {
        // setup
        Hand hand = new Hand(2);

        // invoke
        boolean removed = hand.remove(1);

        // analyze
        assertTrue(hand.isEmpty());
        assertFalse(removed);
    }

    @Test
    public void removeNotThere() {
        // setup
        Hand hand = new Hand(2);
        hand.deal(10);
        hand.deal(12);

        // invoke
        boolean removed = hand.remove(8);

        // analyze
        assertFalse(hand.isEmpty());
        assertFalse(removed);
    }

    @Test
    public void removeFirst() {
        // setup
        int card = 8;
        Hand hand = new Hand(2);
        hand.deal(card);
        hand.deal(98);

        // invoke
        boolean removed = hand.remove(card);

        // analyze
        assertFalse(hand.isEmpty());
        assertTrue(removed);
    }

    @Test
    public void removeLast() {
        // setup
        int card = 90;
        Hand hand = new Hand(2);
        hand.deal(7);
        hand.deal(card);

        // invoke
        boolean removed = hand.remove(card);

        // analyze
        assertFalse(hand.isEmpty());
        assertTrue(removed);
    }

    @Test
    public void removeMiddle() {
        // setup
        int card = 77;
        Hand hand = new Hand(3);
        hand.deal(7);
        hand.deal(card);
        hand.deal(12);

        // invoke
        boolean removed = hand.remove(card);

        // analyze
        assertFalse(hand.isEmpty());
        assertTrue(removed);
    }

    @Test
    public void removeOnly() {
        // setup
        int card = 12;
        Hand hand = new Hand(8);
        hand.deal(card);

        // invoke
        boolean removed = hand.remove(card);

        // analyze
        assertTrue(hand.isEmpty());
        assertTrue(removed);
    }
}
