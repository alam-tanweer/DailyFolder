package unit02.assignment1.elections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CandidateTest {

    @Test
    public void TestCandiateCreation () {
        // Setup
        String expectedName = "Test";
        Party expectedParty = Party.DEMOCRAT;
        Race expectedRace = Race.MAYOR;


        // Invoke
        Candidate actual = new Candidate ("Test", Party.DEMOCRAT, Race.MAYOR);

        // Analysis
        assertEquals (expectedName, actual.getName ());
        assertEquals (expectedParty, actual.getParty ());
        assertEquals (expectedRace, actual.getRace());
    }

    @Test
    public void TestToString () {
        // Setup
        Candidate candidate = new Candidate ("Test", Party.GREEN, Race.JUDGE);
        String expected = "Test: Running for JUDGE as a GREEN.";

        // Invoke
        String actual = candidate.toString ();

        // Analysis
        assertEquals (expected, actual);
    }

    @Test
    public void TestEqual () {
        // Setup
        Candidate candidateA = new Candidate ("Test", Party.LIBERATRIAN, Race.SHERIFF);
        Candidate candidateB = new Candidate ("Test", Party.REPUBLICAN, Race.SHERIFF);

        // Invoke
        boolean acutal = candidateA.equals (candidateB);

        // Analysis
        assertFalse (candidateA == candidateB);
        assertTrue (acutal);
    }

    @Test
    public void TestNotEqual () {
        // Setup
        Candidate candidateA = new Candidate ("Test", Party.LIBERATRIAN, Race.SHERIFF);
        Candidate candidateB = new Candidate ("Test", Party.REPUBLICAN, Race.ASSEMBLY);

        // Invoke
        boolean acutal = candidateA.equals (candidateB);

        // Analysis
        assertFalse (acutal);
    }
    
}
