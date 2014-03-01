import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}

class Solution {
    void solveSudoku(char[][] board) {
         recurSolve(board, 0, 0, 1);
    }
    int recurSolve(char[][] board, int i, int j, int num) {
        int found = 0;
        char pre_val = board[i][j];
        if(board[i][j] != '.') {
            if(i == 8 && j == 8) {
                found = 1;
            }else if(j == 8) {
                found = recurSolve(board, i+1, 0, 1);
            }else {
                found = recurSolve(board, i, j+1, 1);
            }
            return found;
        }else {
            if(isOK(board, i, j, num)) {
                board[i][j] = (char)(num+48);
                if(i == 8 && j == 8) {
                    found = 1;
                }else if(j == 8) {
                    found = recurSolve(board, i+1, 0, 1);
                }else {
                    found = recurSolve(board, i, j+1, 1);
                }
            }
            if(found == 1) return 1;
            board[i][j] = pre_val;
            if(num != 9) {
                found = recurSolve(board, i, j, num+1);
            }
            return found;
        }
    }
    boolean isOK(char[][] board, int i, int j, int num) {
        int m, n, block_i, block_j;
        for(m = 0; m < 9; m++) 
            if(board[i][m]-'0' == num || board[m][j]-'0' == num) 
                return false;
        block_i = i/3 *3;
        block_j = j/3 *3;
        for(m = 0; m < 3; m++) {
            for(n = 0; n < 3; n++) {
                if(num == board[block_i+m][block_j+n]-'0') return false;
            }
        }
        return true;
    }


//        System.out.print();

//        System.out.println();

    void printAL2(ArrayList<ArrayList<Integer>> A) {
        if(A == null) return;
        for(int i =0; i < A.size(); i++ ) {
            for(int j= 0; j < A.get(i).size(); j++ ) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAL(ArrayList<Integer> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
                System.out.print(A.get(i)+" ");
            }
        System.out.println();
    }

    void printAr2(char[][] A) {
        if(A == null) return;
        for(int i =0; i < A.length; i++ ) {
            for(int j= 0; j < A[i].length; j++ ) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAr(int[] A) {
        if(A == null) return;
        for(int i = 0; i < A.length; i++) {
                System.out.print(A[i]+" ");
            }
        System.out.println();
    }

    void printLN(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode genList(int[] A) {
        if(A == null) return null;
        ListNode head = new ListNode(0), node = head;
        for(int i = 0 ; i < A.length; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
        return head.next;
    }

    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A[0]), node = root;
        queue.offer(node);
        for(int i = 1; i < A.length; i++ ) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(true) {
            try {
                root = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(root == null) {
                System.out.print("# ");
            }else {
                System.out.print(root.val+" ");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        System.out.println();
    }
    char[][] genSudoku(int[][] board) {
        char[][] new_board = new char[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 0) {
                    new_board[i][j] = '.';
                }else {
                    new_board[i][j] = (char)(board[i][j] + 48);
                }
            }
        }
        return new_board;
    }
}

public class SolveSudoku{
    public static void main(String[] args) {
        Solution sol = new Solution();
        /*
        int[][] A = {{5,3,4,6,7,8,9,1,2},
                     {6,7,0,1,9,5,3,4,8},
                     {1,9,8,3,4,2,5,6,7},
                     {8,5,9,7,6,0,4,2,3},
                     {4,2,6,8,5,3,0,9,1},
                     {7,1,3,9,2,4,8,5,6},
                     {9,6,0,5,3,7,2,8,4},
                     {2,8,7,4,1,9,6,3,5},
                     {3,4,5,2,8,6,0,7,9}};
        */
        int[][] A = {{5,3,0,0,7,0,0,0,0},
                     {6,0,0,1,9,5,0,0,0},
                     {0,9,8,0,0,0,0,6,0},
                     {8,0,0,0,6,0,0,0,3},
                     {4,0,0,8,0,3,0,0,1},
                     {7,0,0,0,2,0,0,0,6},
                     {0,6,0,0,0,0,2,8,0},
                     {0,0,0,4,1,9,0,0,5},
                     {0,0,0,0,8,0,0,7,9}};
        //int[][] B = {{}};



        char[][] board = sol.genSudoku(A);
        sol.printAr2(board);
        sol.solveSudoku(board);
        sol.printAr2(board);
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
