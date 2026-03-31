package unit11.threadedmergesort;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import java.text.NumberFormat;
import java.util.Locale;

public class ThreadedMergeSort extends Thread {
    private int[] unsorted;
    private int[] sorted;

    public ThreadedMergeSort(int[] unsorted) {
        this.unsorted = unsorted;
        this.sorted = null;
    }

    public int[] getSorted() {
        return sorted;
    }

    @Override
    public void run() {
        sorted = MergeSort.mergeSort(unsorted);
    }

    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            final NumberFormat NUM_FORMAT = NumberFormat.getNumberInstance(Locale.US);
            Random random = new Random(1);

            System.out.print("Enter number of values to sort: ");
            int size = scanner.nextInt();

            System.out.print("Enter maximum number of threads: ");
            int maxThreads = scanner.nextInt();

            int[] unsorted = new int[size];
            for (int i = 0;i < size;++i) {
                unsorted[i] = random.nextInt(size * 4);
            }

            
            long start;
            long end;

            // Do a few warm up sorts to get caching out of the way
            int warmUp = 2;
            for (int i = 0;i < warmUp;++i) {
                start = System.currentTimeMillis();
                MergeSort.mergeSort(unsorted);
                end = System.currentTimeMillis();
                System.out.println("[Warm Up] Threads: 0, Time: " + NUM_FORMAT.format(end - start) + " ms");
            }

            for (int numThreads = 1;numThreads <= maxThreads;++numThreads) {
                start = System.currentTimeMillis();
                int[][] chunks = MergeSort.split(unsorted,numThreads);
                ThreadedMergeSort[] threads = new ThreadedMergeSort[numThreads];
                for (int i = 0;i < numThreads;++i) {
                    threads[i] = new ThreadedMergeSort(chunks[i]);
                    threads[i].start();
                }

                Stack<int[]> sortedChunks = new Stack<>();
                for (int i = 0;i < numThreads;++i) {
                    threads[i].join();
                    sortedChunks.push(threads[i].getSorted());
                }

                while (sortedChunks.size() > 1) {
                    int numMergeThreads = Math.min(sortedChunks.size() / 2,maxThreads);
                    MergeThread[] mergeThreads = new MergeThread[numMergeThreads];
                    for (int i = 0;i < numMergeThreads;++i) {
                        mergeThreads[i] = new MergeThread(sortedChunks.pop(), sortedChunks.pop());
                        mergeThreads[i].start();
                    }

                    for (int i = 0;i < numMergeThreads;++i) {
                        mergeThreads[i].join();
                        sortedChunks.push(mergeThreads[i].getMerged());
                    }
                }

                end = System.currentTimeMillis();
                System.out.println("Threads: " + numThreads + ", Time: " + NUM_FORMAT.format(end - start) + " ms");
            }
        }
    }
}
