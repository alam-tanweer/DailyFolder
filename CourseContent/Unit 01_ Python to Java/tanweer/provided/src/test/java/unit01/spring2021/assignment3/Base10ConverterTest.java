package unit01.spring2021.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static unit01.spring2022.assignment3.Base10Converter.*;

import org.junit.jupiter.api.Test;

import unit01.spring2022.assignment3.Base10Converter;

public class Base10ConverterTest {
    @Test
    public void charToInteger0() {
        // setup
        char digit = '0';
        int expected = 0;

        // invoke
        int actual = charToInteger(digit);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void charToInteger5() {
        // setup
        char digit = '5';
        int expected = 5;

        // invoke
        int actual = charToInteger(digit);

        // analyze
        assertEquals(expected, actual);
    }


    @Test
    public void arrayToIntegerBase10BigEndian() {
        // setup
        char[] digits = {'5', '4', '6', '7'};
        int base = 10;
        boolean bigEndian = true;
        int expected = 5467;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
        
    }

    @Test
    public void arrayToIntegerBase10LittleEndian() {
        // setup
        char[] digits = {'5', '4', '6', '7'};
        int base = 10;
        boolean bigEndian = false;
        int expected = 7645;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
        
    }

    @Test
    public void arrayToIntegerBase8BigEndian() {
        // setup
        char[] digits = {'5', '4', '6', '7'};
        int base = 8;
        boolean bigEndian = true;
        int expected = 2871;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
        
    }

    @Test
    public void arrayToIntegerBase8LittleEndian() {
        // setup
        char[] digits = {'5', '4', '6', '7'};
        int base = 8;
        boolean bigEndian = false;
        int expected = 4005;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void arrayToIntegerBase2BigEndian() {
        // setup
        char[] digits = {'1', '0', '1', '1'};
        int base = 2;
        boolean bigEndian = true;
        int expected = 11;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void arrayToIntegerBase2LittleEndian() {
        // setup
        char[] digits = {'1', '0', '1', '1'};
        int base = 2;
        boolean bigEndian = false;
        int expected = 13;

        // invoke
        int actual = Base10Converter.arrayToInteger(digits, base, bigEndian);

        // analyze
        assertEquals(expected, actual);
    }
}
