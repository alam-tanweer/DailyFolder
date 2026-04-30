package finalexam.taskassignment;

import java.util.*;
import finalexam.backtracker.*;

public class TaskAssignment implements Configuration<TaskAssignment> {

    private List<Integer> remaining;
    private List<Integer> selected;
    private int target;

    public TaskAssignment(List<Integer> tasks, int target) {
        this.remaining = tasks;
        this.selected = new ArrayList<>();
        this.target = target;
    }

    private TaskAssignment(List<Integer> remaining, List<Integer> selected, int target) {
        this.remaining = remaining;
        this.selected = selected;
        this.target = target;
    }

    @Override
    public Collection<TaskAssignment> getSuccessors() {
        Collection<TaskAssignment> successors = new ArrayList<>();

        // First implementation
        // if (remaining.isEmpty())
        //     return successors;

        // int first = remaining.get(0);

        // // remove first task from remaining
        // List<Integer> remainingCopy1 = new ArrayList<>(remaining);
        // remainingCopy1.remove(0);

        // // OPTION 1: include task
        // List<Integer> selectedCopy = new ArrayList<>(selected);
        // selectedCopy.add(first);
        // successors.add(new TaskAssignment(remainingCopy1, selectedCopy, target));

        // // OPTION 2: skip task
        // successors.add(new TaskAssignment(remainingCopy1, new ArrayList<>(selected), target));

        // Second Implementation

        // int size = remaining.size();
        // for(int i=0; i< size; i++) {

        // int first = remaining.remove(0);

        // List<Integer> remainingCopy1 = new ArrayList<>(remaining);
        // // remainingCopy1.remove(0);

        // List<Integer> selectedCopy = new ArrayList<>(selected);
        // selectedCopy.add(first);

        // successors.add(new TaskAssignment(remainingCopy1, selectedCopy, target));

        // }

        // Third implemnetation
        if (!remaining.isEmpty()) {
            int currentTask = remaining.get(0);

            List<Integer> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove(0);

            // Option 1: include current task
            List<Integer> includeSelected = new ArrayList<>(selected);
            includeSelected.add(currentTask);
            successors.add(new TaskAssignment(newRemaining, includeSelected, target));

            // Option 2: skip current task
            List<Integer> skipSelected = new ArrayList<>(selected);
            successors.add(new TaskAssignment(newRemaining, skipSelected, target));
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        return sum(selected) <= target;
    }

    @Override
    public boolean isGoal() {
        return sum(selected) == target;
    }

    @Override
    public String toString() {
        return "Selected=" + selected + ", Sum=" + sum(selected);
    }

    private int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        Backtracker<TaskAssignment> solver = new Backtracker<>(false);

        TaskAssignment t1 = new TaskAssignment(Arrays.asList(2,3,5,7), 10);
        TaskAssignment sol1 = solver.solve(t1);
        System.out.println("Tasks: [2,3,5,7], Target=10");
        System.out.println(sol1 != null ? "Solution: " + sol1 : "No solution found");

        TaskAssignment t2 = new TaskAssignment(Arrays.asList(2,4,6), 5);
        TaskAssignment sol2 = solver.solve(t2);
        System.out.println("\nTasks: [2,4,6], Target=5");
        System.out.println(sol2 != null ? "Solution: " + sol2 : "No solution found");

        TaskAssignment t3 = new TaskAssignment(Arrays.asList(1, 9, 4, 6), 10);
        TaskAssignment sol3 = solver.solve(t3);
        System.out.println("\nTasks: [(1,4,6,9)], Target=10");
        System.out.println(sol3 != null ? "Solution: " + sol3 : "No solution found");
    }
}