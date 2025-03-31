package Greedy.Basic;
import java.util.*;

public class MinAbsolutePair {
    public static void main(String[] args) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        int S = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            S += Math.abs(A[i] - B[i]);
        }

        System.out.println("Min sum of absolute value = "  + S);
    }
}
