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
    boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 ||board[0].length == 0) {
            if(word == null || word.length() == 0) return true;
            else return false;
        }
        int i, j;
        char pre_val;
        for(i = 0; i < board.length;i ++) {
            for(j = 0; j < board[i].length; j++) {
                if(board[i][j] != word.charAt(0)) continue;
                else if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1) return true;
                    pre_val = board[i][j];
                    board[i][j] = '#'; 
                    if(recurSolve(board, i,j, word,1)) return true;
                    else board[i][j] = pre_val;
                }
            }
        }
        return false;
    }
    boolean recurSolve(char[][] board, int i, int j, String word, int idx) {
        int k, new_i, new_j;
        int[] new_ij;
        char pre_val;
        if(idx == word.length()-1) {
            for(k = 0; k < 4; k++) {
                new_ij = newij(i, j, k);
                new_i =new_ij[0]; new_j = new_ij[1];
                if(feasible(board, new_i, new_j, word, idx)) return true;
            }
        }else {
            for(k = 0; k < 4; k++) {
                new_ij = newij(i, j, k);
                new_i =new_ij[0]; new_j = new_ij[1];
                if(feasible(board, new_i, new_j, word, idx)) {
                    pre_val = board[new_i][new_j];
                    board[new_i][new_j] = '#';
                    if(recurSolve(board, new_i, new_j, word, idx+1)) return true;
                    else board[new_i][new_j] = pre_val;
                }
            }
        }
        return false;
    }
    int[] newij(int i, int j, int k) {
        int[] new_ij = new int[2];
        switch(k) {
            case 0: i = i-1;;break;
            case 1: j = j+1;break;
            case 2: i = i+1;break;
            case 3: j = j-1;break;
            default: System.out.println("Invalid direction!");break;
        }
        new_ij[0] = i;
        new_ij[1] = j;
        return new_ij;
    }

    boolean feasible(char[][] board, int i, int j, String word, int idx) {
        if(i < 0 || i >= board.length ||
           j < 0 || j >= board[0].length ||
           board[i][j] != word.charAt(idx)) return false;
        return true;
    }
    char[][] genBoard(String[] A) {
        if(A == null || A.length == 0) return null;
        char[][] board = new char[A.length][A[0].length()];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = A[i].charAt(j);
            }
        }
        return board;
    }

    /*
            if(feasible(i-1, j)&& board[i-1][j] == idx) return true;
            if(feasible(i, j+1)&& board[i][j+1] == idx) return true;
            if(feasible(i+1, j)&& board[i+1][j] == idx) return true;
            if(feasible(i, j-1)&& board[i][j-1] == idx) return true;
        }else {
            if(feasible(i-1, j)&& board[i-1][j] == idx) {
               pre_val = board[i-1][j];
               board[i-1][j] = '#';
               if(recurSolve(board, i-1, j, idx+1)) return true;
               else board[i-1][j] = pre_val;
            if(feasible(i, j+1)&& board[i][j+1] == idx &&
               pre_val = board[i][j+1];
               board[i][j+1] = '#';
               if(recurSolve(board, i, j+1, idx+1)) return true;
               else board[i][j+1] = pre_val;
            if(feasible(i+1, j)&& board[i+1][j] == idx &&
               pre_val = board[i+1][j];
               board[i+1][j] = '#';
               if(recurSolve(board, i+1, j, idx+1)) return true;
               else board[i+1][j] = pre_val;
            if(feasible(i, j-1)&& board[i][j-1] == idx &&
               pre_val = board[i][j-1];
               board[i][j-1] = '#';
               if(recurSolve(board, i, j-1, idx+1)) return true;
               else board[i][j-1] = pre_val;
               */
            

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
}

public class Exist  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] A = {{"aa"},{"aaaa","aaaa","aaaa","aaaa","aaab"},
                        {},{"ABCE","SFCS","ADEE"},{"a"},
                        {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"}};
        String[][] B = {{"a"},{"aaaaaaaaaaaaaaaaaaaa"},
                        {"","A"},{"ABCCED","SEE","ABCB","ABCESCFSADEE"},{"ab"},
                        {"baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}};
        char[][] board;



        for(int i = 0; i < A.length ; i++) {
                board = sol.genBoard(A[i]);
                sol.printAr2(board);
            for(int j = 0; j < B[i].length; j++) {
                System.out.println(B[i][j]);
                board = sol.genBoard(A[i]);
                System.out.println(sol.exist(board,B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
