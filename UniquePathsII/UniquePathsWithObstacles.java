class Solution {
    int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 ||
           obstacleGrid[0].length == 0) return 0;
        int i, j, m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                }else {
                    if(i == 0 && j == 0) {
                        paths[i][j] = 1;
                    }else if(i == 0) {
                        paths[i][j] = paths[i][j-1];
                    }else if(j == 0) {
                        paths[i][j] = paths[i-1][j];
                    }else {
                        paths[i][j] = paths[i-1][j] +paths[i][j-1]; 
                    }
                }
            }
        }
        return paths[m-1][n-1];
    }
}
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        //int[][] grid = {{1,0,0},{0,1,0},{0,0,0}};
        //int[][] grid = {{0,0,0}};
        int[][] grid = {{1}};
        Solution sol = new Solution();
        System.out.println(sol.uniquePathsWithObstacles(grid));
    }
}

