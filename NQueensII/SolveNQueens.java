import java.util.*;
class Solution {
    ArrayList<String[]> A = new ArrayList<String[]>();
    int n;

    ArrayList<String[]> solveNQueens(int x) {
        if(x == 0) return A;
        n = x;
        int[][] chess_board = new int[n][n];
        check(Arrays.copyOf(chess_board, n), 0, 0);
        return A;
    }

    void check(int[][] chess_board, int i, int j) {
        
        //if(i == 2 && j ==1)
        //System.out.println(i+" "+j);
       
        if(chess_board[i][j] != -1) {
            if(j == n-1) {
                A.add(int_array_to_str(update(chess_board,i,j)));
            }else {
                check(update(chess_board, i, j), 0, j+1);
            }
        }
        if(i == n-1) {
            return;
        }else {
            check(Arrays.copyOf(chess_board, n), i+1, j);
        }
    }
    int[][] update(int[][] chess_board, int i, int j) {
        int[][] new_chess_board = new int[n][n];
        for(int m = 0; m < n; m++) {
            new_chess_board[m] = Arrays.copyOf(chess_board[m], n);
        }
        new_chess_board[i][j] = 1;
        if(j == n-1) {
            return new_chess_board;
        }else {
            for(int k = j+1; k < n; k++) {
                for(int l = 0; l < n; l++) {
                    if(l == i || l+k == i+j || l-k == i-j) {
                        new_chess_board[l][k] = -1;
                    }
                }
            }
        }
        return new_chess_board;
    }
    String[] int_array_to_str(int[][] chess_board) {
        String[] solution = new String[n];
        for(int i = 0; i < n; i++) {
            String line = new String();
            for(int j = 0; j < n; j++) {
                if(chess_board[i][j] == 1) {
                    line += "Q";
                }else {
                    line += ".";
                }
            }
            solution[i] = line;
        }
        return solution;
    }
    void print(ArrayList<String[]> A) {
        for(int k = 0; k < A.size(); k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(A.get(k)[i].charAt(j));
                }
                System.out.println();
            }
        }
    }
}
public class SolveNQueens {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //sol.print(sol.solveNQueens(2));
        System.out.println(sol.solveNQueens(10).size());
    }
}





    




