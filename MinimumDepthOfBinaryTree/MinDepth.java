import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}
class Solution {
    int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 1, n_this_level = 1, n_next_level = 0, level = 1;
        queue.offer(root);
        while(true) {
            try {
                root = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(root.left == null && root.right == null) {
                return level;
            }else {
                if(root.left != null) {
                    queue.offer(root.left);
                    n_next_level += 1;
                }
                if(root.right != null) {
                    queue.offer(root.right);
                    n_next_level += 1;
                }
            }
            if(i == n_this_level) {
                i = 0;
                n_this_level = n_next_level;
                n_next_level = 0;
                level += 1;
            }
            i += 1;
        }
        return 1;
    }
    TreeNode growTree(int[] A) {
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
    }
}
public class MinDepth {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{1},{1,2,3,-1,4},{1,2,-1,3},
                     {1,-1,3,-1,4},{1,2,3,4,5}};
        Solution[] sol = new Solution[A.length];
        for(int i = 0; i < A.length; i++) {
            sol[i] = new Solution();
            sol[i].printTree(sol[i].growTree(A[i]));
            System.out.println(sol[i].minDepth(sol[i].growTree(A[i])));
        }
    }
}
                
