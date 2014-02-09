class Solution {
    void merge(int A[], int m, int B[], int n) {
        if (A == null) return;
        int[] C = new int[m+n];
        int i = 0, j = 0;
        while (true) {
            if (i < m && j < n) {
                if (A[i] < B[j]) {
                    C[i+j] = A[i];
                    i += 1;
                }else {
                    C[i+j] = B[j];
                    j += 1;
                }
            }else if (i < m) {
                C[i+j] = A[i];
                i += 1;
            }else if (j < n) {
                C[i+j] = B[j];
                j += 1;
            }else {
                break;
            }
        }
        System.arraycopy(C, 0, A, 0, m+n);
    }
    void printArray(int[] A) {
        int i, len = A.length;
        for(i = 0; i < len; i++) {
            System.out.println(A[i]);
        }
    }
}

public class Merge {
    public static void main(String[] args) {
        int[] A = {1,3,4,7,8,8,0,0,0,0};
        int[] B = {1,2,5,9};
        int m = A.length-B.length, n = B.length;        
        Solution sol = new Solution();
        sol.merge(null, 0, null, 0);
        sol.printArray(A);
    }
}


