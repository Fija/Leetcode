class Solution {
    int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;

        int i, j;
        int[][] path = new int[m][n];

        for(i = 0; i < m; i++) {
            for(j = 0;j < n;j++) {
                if(i == 0 || j == 0) {
                    path[i][j] = 1;
                }else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
public class UniquePaths {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(100,5));
    }
}

