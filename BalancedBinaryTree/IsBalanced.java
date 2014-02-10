import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}
class Solution {
    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }else if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }else return false;
    }
    int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
        }
    }
    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null; 
        int i, len = A.length;
        TreeNode node, head = new TreeNode(A[0]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(head);
        node = head;
        for(i = 1;i < len;i++) {
            try {
                node = queue.removeFirst();
            }catch (Exception ex) {
                break;
            }
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i >= len) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return head; 
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
        for(queue.offer(root);;) {
            try {
                root = queue.removeFirst();
            }catch(Exception ex) {
                break;
            }
            if(root == null) {
                System.out.println("#");
            }else {
                System.out.println(root.val);
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
    }
}
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root;
        Solution sol = new Solution();
        int[][] A = {null,{},{1,2,3,-1,-1,4,-1,5},{1,2},
                    {1,2,3,4,5,6,-1,7},{-1},{1,2,-1,3}};
        boolean[] B = {true,true,false,true,true,true,false};
        for(int i = 0; i < A.length; i++) {
            root = sol.growTree(A[i]);
            if(sol.isBalanced(root) == B[i]) {
                System.out.println("Answer is correct");
            }else {
                System.out.println("Answer is wrong for tree:");
                sol.printTree(root);
            }
        }
    }
}
