class Solution {
    boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
           return false;
        int m = matrix.length, n = matrix[0].length, right, left, i, j, mid; 
        if(matrix[0][0] == target || matrix[m-1][n-1] == target) return true;
        if(matrix[0][0] > target || matrix[m-1][n-1] < target) return false;
        left = 0; right = m * n - 1;
        for(;right-left > 1;) {
            mid = left + (right-left)/2;
            i = mid / n;
            j = mid % n;
            //System.out.println(left+" "+mid+" "+right+" "+i+" "+j);
            if(target == matrix[i][j]) {
                return true;
            }else if(target < matrix[i][j]) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return false;
    }
}
public class SearchMatrix {
    public static void main(String[] args) {
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //int[][] matrix = {{1}};
        int[][] matrix = {{1,2,4}};
        Solution sol = new Solution();
        if(sol.searchMatrix(matrix, 3)) {
            System.out.println("True!");
        }else {
            System.out.println("False!");
        }
    }
}


