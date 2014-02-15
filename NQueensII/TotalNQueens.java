class Solution {
    ArrayList<String[]> A;
    ArrayList<String[]> SolveNQueens(int n) {
        String[] chess_board = new String[]();
        A = new ArrayList<String[]>();
        for(i = 0; i < n; i++) {
            char[] chars = new char[n];
            Array.fill(chars, '.');
            chess_board.add(new String(chars));
        }
        try(chess_board,0,0);
    }
    void try(String[] chess_board, int i, int j) {
        for(k = 0; k < n; k++) {
            if(chess_board[k].charAt(j) != 'x') {
                chess_board[k] = chess_board[k].substring(0,j-1)+'Q'
                                 +chess_board[k].substring(j+1);




        

        
