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
    ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        if(matrix == null ||matrix.length == 0 || matrix[0].length == 0) return A;
        int i=0, j=0, m = matrix.length, n = matrix[0].length;
        while(true) {
            A.add(matrix[i][j]);
            if(A.size() == m*n) break;
            if(j >= i-1 && j+i < n-1 && i <= (m-1)/2) j += 1;
            else if(j+i >= n-1 && i-j < m-n && j >= n/2) i += 1;
            else if(i-j >= m-n && j+i > m-1 && i > (m-1)/2) j -= 1;
            else if(i+j <= m-1 && j < i-1 && j < n/2) i -= 1;
        }
        return A; 
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

public class SpiralOrder {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][][] A = {{{1,2},{3,4},{5,6}},
                       {{1,2,3},{4,5,6}},
                       {{1,2,3}},
                       {{1,2,3},{4,5,6},{7,8,9}},
                       {{1},{2},{3}},
                       {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}}};



        for(int i = 0; i < A.length ; i++) {
            sol.printAL(sol.spiralOrder(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}

