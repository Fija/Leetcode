class Solution {
    private static final int ASCII_DOT = 46;
    boolean isValidSudoku(char[][] board) {
        return rowOK(board) && colOK(board) && blockOK(board);
    }
    boolean rowOK(char[][] board) {
        int[] map = new int[60];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if((int)board[i][j] != ASCII_DOT) {
                    if(map[(int)board[i][j]] > 0) {
                        return false;
                    }else {
                        map[(int)board[i][j]] = 1;
                    }
                }
            }
            map = new int[60];
        }
        return true;
    }
    boolean colOK(char[][] board) {
        int[] map = new int[60];
        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                if((int)board[i][j] != ASCII_DOT) {
                    if(map[(int)board[i][j]] > 0) {
                        return false;
                    }else {
                        map[(int)board[i][j]] = 1;
                    }
                }
            }
            map = new int[60];
        }
        return true;
    }
    boolean blockOK(char[][] board) {
        for(int i = 0; i <=6; i+= 3) {
            for(int j = 0; j <= 6; j+= 3) {
                if(!smallBlockOK(board,i,j)) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean smallBlockOK(char[][] board, int i, int j) {
        int[] map = new int[60];
        for(int m = 0; m < 3; m++) {
            for(int n=0; n < 3; n++) {
                if((int)board[i+m][j+n] != ASCII_DOT) {
                    if(map[(int)board[i+m][j+n]] > 0) {
                        return false;
                    }else map[(int)board[i+m][j+n]] = 1;
                }
            }
        }
        return true;
    }
    char[][] intToChar(int[][] A) {
        char[][] board = new char[9][9];
        for(int i =0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(A[i][j] == 0) {
                    board[i][j] = '.';
                }else {
                    board[i][j] = (char)('0'+A[i][j]);
                }
            }
        }
        return board;
    }


}
public class IsValidSudoku {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{5,3,0,0,7,0,0,0,0},
                     {6,0,0,1,9,5,0,0,0},
                     {0,9,8,0,0,0,0,6,0},
                     {8,0,0,0,6,0,0,0,3},
                     {4,0,0,8,0,3,0,0,1},
                     {7,0,0,0,2,0,0,0,6},
                     {0,6,0,0,0,0,2,8,0},
                     {0,0,0,4,1,9,0,0,5},
                     {0,0,0,0,8,0,0,7,9}};
        if(sol.isValidSudoku(sol.intToChar(A))){
            System.out.println("T");
        }else {
           System.out.println("F");
        }
    }
}
            

            

        
