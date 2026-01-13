package unit01.spring2020.assignment3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import unit01.spring2021.assignment3.SieveValidator;

public class SieveValidatorTest {
    @Test
    public void repairSieveNoRepairs() {
        // setup
        int[] repaired = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
        int[] sieve = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1};

        // invoke
        SieveValidator.repairSieve(sieve);

        // analyze
        assertArrayEquals(repaired, sieve);
    }

    @Test
    public void repairSieveOneRepair() {
        // setup
        int[] repaired = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
        int[] sieve = {1, 1, 0, 0, 1, 0, 1, 0, 1, 0};

        // invoke
        SieveValidator.repairSieve(sieve);

        // analyze
        assertArrayEquals(repaired, sieve);
    }

    @Test
    public void repairSieveTwoRepairs() {
        // setup
        int[] repaired = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
        int[] sieve = {1, 1, 0, 0, 1, 1, 1, 0, 1, 0};

        // invoke
        SieveValidator.repairSieve(sieve);

        // analyze
        assertArrayEquals(repaired, sieve);
    }
}
