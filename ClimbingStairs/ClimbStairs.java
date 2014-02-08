class Solution {
    int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] A = new int[n+1];
        int i = 2;
        A[0] = 1;
        A[1] = 1;
        while (i <= n) {
            A[i] = A[i-1] + A[i-2];
            i += 1;
        }
        return A[n];
    }
}
public class ClimbStairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(5));
    }
}
