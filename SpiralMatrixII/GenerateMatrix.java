class Solution {
    int[][] generateMatrix(int n) {
        int i, j, k;
        int[][] mat = new int[n][n];
        if(n == 0) return mat;
        for(k = 1, i = 0, j = 0, mat[0][0] = 1;;k++) {
            if((i == 0 || mat[i-1][j] != 0) && (j == 0 || mat[i][j-1] != 0)
                && (j != n-1 && mat[i][j+1] == 0)) {
                mat[i][j+1] = k+1; 
                j += 1;
            }else if((i == 0 || mat[i-1][j] != 0) && (j == n-1 || mat[i][j+1] != 0)
                      &&(i != n-1 && mat[i+1][j] == 0)) {
                mat[i+1][j] = k+1;
                i += 1;
            }else if((i == n-1 || mat[i+1][j] != 0) && (j == n-1 || mat[i][j+1] != 0)
                      &&(j != 0 && mat[i][j-1] == 0)) {
                mat[i][j-1] = k+1;
                j -= 1;
            }else if((i == n-1 || mat[i+1][j] != 0) && (j == 0 || mat[i][j-1] != 0)
                      &&(i != 0 && mat[i-1][j] == 0)) {
                mat[i-1][j] = k+1;
                i -= 1;
            }else {
                break;
            }
        }
        return mat;
    }
    void print(int[][] mat) {
        if(mat == null) return;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

public class GenerateMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.print(sol.generateMatrix(3));
    }
}

                 
