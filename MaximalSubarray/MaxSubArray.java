class Solution {
    int pmaxSubArray(int[] A) {
        if (A == null) return 0;
        int i = 1, len = A.length, current = A[0],
            max = A[0], maxstart = 0, maxend = 0, start = 0;
        while(i < len) {
            if (current >=0 && A[i] + current >=0) {
                current = A[i] + current;
            }else {
                start = i;
                current = A[i];
            }
            if (current > max) {
                max = current;
                maxstart = start;
                maxend = i;
            }
            i += 1;
        }
        for (i = maxstart; i <= maxend; i++) {
            System.out.println(A[i]);
        }
        System.out.println('\n');
        return max;
    }
    int maxSubArray(int[] A) {
        if (A == null) return 0;
        int i = 1, len = A.length, current = A[0], max = A[0];
        while(i < len) {
            if (current >=0 && A[i] + current >=0) {
                current = A[i] + current;
            }else {
                current = A[i];
            }
            if (current > max) {
                max = current;
            }
            i += 1;
        }
        return max;
    }
}

public class MaxSubArray {
    public static void main(String[] args) {
        //int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        int[] A = {-2,-3,-1,100};
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(A));
    }
}


