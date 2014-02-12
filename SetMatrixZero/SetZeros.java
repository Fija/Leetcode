import java.util.*;
class Solution {
    void setZeros(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int i, j, k, m = matrix.length, n = matrix[0].length; 
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(matrix[i][j] == 0 || matrix[i][j] == 0x7B19BEE5) {
                    for(k = 0; k < m; k++) {
                        if(k > i) {
                            if(matrix[k][j] == 0) {
                                matrix[k][j] = 0x7B19BEE5;
                                break;
                            }else matrix[k][j] = 0x7AC0BE11; 
                        }else matrix[k][j] = 0;
                    }
                    for(k = 0; k < n; k++) {
                        if(k > j && (matrix[i][k] == 0 || matrix[i][k] == 0x7B19BEE5)) {
                            matrix[i][k] = 0x7B19BEE5;
                            break;
                        }else {
                            matrix[i][k] = 0;
                        }
                    }
                    j = k-1;
                }else if(matrix[i][j] == 0x7AC0BE11) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void print(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
       void wrong_setZeros(int[][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
       int s, t, i, j, k;
       ArrayList<Integer> r_remain = new ArrayList<Integer>();
       ArrayList<Integer> c_remain = new ArrayList<Integer>();
       for(i = 0; i < matrix.length; i++) {
       r_remain.add(i);
       }
       for(i = 0; i < matrix[0].length; i++) {
       c_remain.add(i);
       }
       for(s = 0; s < r_remain.size(); s++) {
       for(t = 0; t < c_remain.size(); t++) {
       i = r_remain.get(s);
       j = c_remain.get(t);
       System.out.println("status: " + i + " " + j + " " + matrix[i][j] + "\n");
       print(matrix);
       if(matrix[i][j] == 0) {
       for(k = 0; k < c_remain.size(); k++) {
       matrix[i][c_remain.get(k)] = 0;
       }
       for(k = 0; k < r_remain.size(); k++) {
       matrix[r_remain.get(k)][j] = 0;
       }
       r_remain.remove(new Integer(i));
       c_remain.remove(new Integer(j));
       t = -1;
       if(s >= r_remain.size()) {
       return;
       }
       }
       }
       }
       }*/
}

public class SetZeros {
    public static void main(String[] args) {
        //int[][] A = {{1,0,2},{3,4,5},{6,7,0}};
        //int[][] A = {{1,2,3,4},{5,6,0,7},{8,9,4,7},{5,3,2,0}};
        //int[][] A = {{1,2,3,4},{5,6,0,7},{8,9,4,7}};
        //int[][] A = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        //int[][] A = {{}};
        int[][] A = {{9,0,0,4,2,3,1},{7,5,0,6,5,5,5},{7,2,6,2,7,2,5},{9,7,5,9,6,9,2},{8,0,0,9,2,1,3},{4,6,6,4,1,6,0},{7,3,5,6,7,4,0},{4,6,6,6,3,3,5},{2,3,9,2,3,0,1}};
        Solution sol = new Solution();
        sol.print(A);
        sol.setZeros(A);
        sol.print(A);
    }
}






