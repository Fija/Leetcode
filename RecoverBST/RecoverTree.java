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
    void recoverTree(TreeNode root) {
        TreeNode pre_node = null, small = null, big = null;
        boolean is_big = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else if(!stack.empty()){
                root = stack.pop();
                if(pre_node == null) pre_node = root;
                if(root.val < pre_node.val) {
                    if(is_big == false) {
                        big = pre_node;
                        small = root;
                        is_big = true;
                    }else {
                        small = root;
                    }
                }
                pre_node = root;
                root = root.right;
            }else break;
        }
        if(small != null && big != null) {
            small.val += big.val;
            big.val = small.val-big.val;
            small.val = small.val-big.val;
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

public class RecoverTree  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root;
        int[][] A = {{},{5},{2,-1,1},{8,3,6,1,10,-1,14,-1,-1,4,7,13}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            root = sol.growTree(A[i]); 
            sol.printTree(root);
            sol.recoverTree(root);
            sol.printTree(root);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
