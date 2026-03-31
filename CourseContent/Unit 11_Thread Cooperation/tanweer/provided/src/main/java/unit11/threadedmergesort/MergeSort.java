package unit11.threadedmergesort;

public class MergeSort {
    
    public static int[][] split(int[] array,int segments) {
        int segmentLen = (array.length) / segments;
        int[][] splits = new int[segments][];

        int index = 0;
        for (int i = 0; i < segments;++i) {
            if (i == segments - 1) // last segment may be a bit longer
                segmentLen = array.length - index;

            splits[i] = new int[segmentLen];
            for (int j = 0;j < segmentLen;++j,++index) {
                splits[i][j] = array[index];
            }
        }

        return splits;
    }

    public static int[] merge(int[] half1, int[] half2) {
        int[] merged = new int[half1.length + half2.length];
        int h1 = 0;
        int h2 = 0;
        int m = 0;

        while (h1 < half1.length && h2 < half2.length) {
            if (half1[h1] <= half2[h2]) {
                merged[m] = half1[h1];
                ++h1;
            }
            else {
                merged[m] = half2[h2];
                ++h2;
            }
            ++m;
        }

        if (h1 == half1.length) {
            for (;h2 < half2.length;++h2,++m)
                merged[m] = half2[h2];
        }
        else {
            for (;h1 < half1.length;++h1,++m)
            merged[m] = half1[h1]; 
        }

        return merged;
    }

    public static int[] mergeSort(int[] unsorted) {
        if (unsorted.length <= 1)
            return unsorted;

        int[][] halves = split(unsorted,2);

        return merge(mergeSort(halves[0]),mergeSort(halves[1]));
    }
}
