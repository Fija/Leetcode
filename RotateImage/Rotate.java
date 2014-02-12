class Solution {
    void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int i, j, n = matrix.length, tmp;
        for(i = 0; i < n/2; i++) {
            for(j = i; j < n-1-i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
    void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
}

public class Rotate{
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,2},{4,5}};
        //int[][] matrix = {{}};
        Solution sol = new Solution();
        sol.print(matrix);
        sol.rotate(matrix);
        sol.print(matrix);
    }
}
    


