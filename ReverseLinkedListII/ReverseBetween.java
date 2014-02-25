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
    ListNode reverseBetween(ListNode head, int m, int n) {
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        ListNode prev_head = new ListNode(0), node = prev_head;
        prev_head.next = head;
        int i = 0;
        while(node != null) {
            if(i >= m-1 && i <= n+1) array.add(node);
            i+=1;
            node = node.next;
            if(node == null && i == n+1) array.add(node);
        }
        for(i = array.size()-2; i > 1; i--) {
            array.get(i).next = array.get(i-1);
        }
        array.get(0).next = array.get(array.size()-2);
        array.get(1).next = array.get(array.size()-1);
        return prev_head.next;
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

public class ReverseBetween  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1},{1,2,3,4,5}};
        int[][][] B = {{{1,1}},{{5,5},{2,4},{2,5},{1,5}}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            sol.printLN(sol.genList(A[i]));
            sol.printLN(sol.reverseBetween(sol.genList(A[i]),B[i][j][0],B[i][j][1]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
