package unit04.practicum.courses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleMaker {
    /**
     * Makes a schedule by choosing the next course with the earliest end time
     * that does not overlap the previous course.
     * 
     * @param courses The list of courses from which to choose.
     * @return The courses selected for the schedule.
     */
    public static List<Course> makeSchedule(List<Course> courses) {
        List<Course> schedule = new ArrayList<>();
        // sort by earliest end time and add first course
        Collections.sort(courses, new CourseEndTimeComparator());
        Course last = courses.get(0);
        schedule.add(last);
        // loop over remaining courses in finish time order, add each
        // course that does not overlap the previous
        for(int i=1; i<courses.size(); i++) {
            Course course = courses.get(i);
            if(course.getStart() >= last.getEnd()) {
                last = course;
                schedule.add(course);
            }
        }
        // return the selected courses
        return schedule;
    }
    
    public static void main(String[] args) {
        System.out.println(makeSchedule(Course.exampleCourses()));
    }
}
