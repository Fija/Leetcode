class Solution {
    int removeDuplicates(int[] A) {
        if (A == null) return 0;
        int i,j,len = A.length;
        if (len == 0) return 0;
        for (i = 0,j = 0; i < len; i++) {
            if (A[i] != A[j]) {
                j += 1;
                A[j] = A[i];
            }
        }
        return j+1;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        //int[] A = {2,2,2,2,2,2,3};
        int[] A = {};
        int i,ans,len = A.length;
        Solution sol = new Solution();
        ans = sol.removeDuplicates(A);
        for (i = 0; i < ans; i++) {
            System.out.println(A[i]);
        }
    }
}
