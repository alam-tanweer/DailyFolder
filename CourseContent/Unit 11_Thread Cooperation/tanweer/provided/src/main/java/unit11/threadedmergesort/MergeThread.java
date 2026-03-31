package unit11.threadedmergesort;

public class MergeThread extends Thread {
    private int[] part1;
    private int[] part2;
    private int[] merged;

    public MergeThread(int[] part1,int[] part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public int[] getMerged() {return merged;}

    @Override
    public void run() {
        merged = MergeSort.merge(part1,part2);
    } 
}
