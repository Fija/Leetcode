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
    boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }else {
            return (max(root.left) < root.val && min(root.right) > root.val &&
                    isValidBST(root.left) && isValidBST(root.right));
        }
    }
    int max(TreeNode node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }else {
            int left = max(node.left), right = max(node.right);
            if(left > right) {
                if(node.val > left) return node.val;
                else return left;
            }else {
                if(node.val > right) return node.val;
                else return right;
            }
        }
    }
    int min(TreeNode node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }else {
            int left = min(node.left), right = min(node.right);
            if(left < right) {
                if(node.val < left) return node.val;
                else return left;
            }else {
                if(node.val < right) return node.val;
                else return right;
            }
        }
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

public class  IsValidBST{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0,-2},{1},{8,3,10,1,6,-1,14,-1,-1,4,9,13}};



        for(int i = 0; i < A.length ; i++) {
            sol.printTree(sol.growTree(A[i]));
            if(sol.isValidBST(sol.growTree(A[i])))
                System.out.println("T");
            else
                System.out.println("F");
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
