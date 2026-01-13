package unit01.spring2021.pss3;

public class Problem02 {
    // O(n^2) complexity
    public static int[] makeSieve(int size) {
        int[] sieve = new int[size];

        sieve[0] = 1;
        sieve[1] = 1;

        for(int i=2; i<size; i++) {
            if(sieve[i] == 0) {
                for(int n=2; n*i<size; n++) {
                    sieve[n*i] = 1;
                }
            }
        }

        return sieve;
    }
}
