package unit04.practicum.courses;

import java.util.Comparator;

/**
 * The optimal solution for 8.1 - choose classes with the earliest finish time.
 */
public class CourseEndTimeComparator implements Comparator<Course> {  
    @Override
    public int compare(Course o1, Course o2) {
        return o1.getEnd() <= o2.getEnd() ? -1 : 1;
    }
}
