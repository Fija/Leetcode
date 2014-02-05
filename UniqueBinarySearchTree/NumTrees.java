class Solution {
    int numTrees(int n) {
        int sum = 0;
        int i;
        if (n == 0 || n== 1) {
            return 1;
        }else {
            for (i = 0; i < n; i++) {
                sum += numTrees(i)*numTrees(n-1-i);
            }
            return sum;
        }
    }
} 
public class NumTrees {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTrees(3));
    }
}

