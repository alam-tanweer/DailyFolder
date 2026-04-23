package unit13.assignment1.ritclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class CourseTest {
    
    @Test
    public void TestComparable () {
        // Setup
        String[] COURSES = {"SWEN-124 02", "CSEC 124-02", "SWEN 124 04", "CSEC-124-04"};
        RITClass[] courses = new RITClass [COURSES.length];
        for (int i = 0; i < COURSES.length; i++) {
            courses [i] = new RITClass (COURSES [i]);
        }

        // Invoke
        Arrays.sort (courses);

        // Analysis
        assertEquals ("CSEC 124-02", courses[0].toString());
        assertEquals ("CSEC 124-04", courses[1].toString());
        assertEquals ("SWEN 124-02", courses[2].toString());
        assertEquals ("SWEN 124-04", courses[3].toString());   
    }

    @Test
    public void TestComparator () {
        // Setup
        String[] COURSES = {"SWEN-123 02", "SWEN 124-02", "SWEN 124 04", "CSEC-124-04"};
        Set<RITClass> courses = new TreeSet<> (new CourseComparator());
        int expectedSize = 3;

        // Invoke
        for (int i = 0; i < COURSES.length; i++) {
            courses.add (new RITClass (COURSES [i]));
        }
        
        // Analysis
        Object[] actual = courses.toArray ();
        assertEquals (expectedSize, courses.size());
        assertEquals ("CSEC 124-04", actual[0].toString());
        assertEquals ("SWEN 124-02", actual[1].toString());
        assertEquals ("SWEN 123-02", actual[2].toString());   
        
    }
}
