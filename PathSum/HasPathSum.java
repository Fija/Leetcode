import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}

class Solution {
    boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        LinkedList<TreeNode> tree_stack = new LinkedList<TreeNode>();
        LinkedList<Integer> path_sum_stack = new LinkedList<Integer>();
        TreeNode node = root;
        Integer path_sum = new Integer(root.val); 
        tree_stack.push(node);
        path_sum_stack.push(path_sum);
        for(;;) {
            try{
                node = tree_stack.pop();
                path_sum = path_sum_stack.pop();
                //System.out.println(path_sum);
            }catch(Exception ex) {
                break;
            }
            if(node.right != null) {
                tree_stack.push(node.right);
                //System.out.println("val ="+node.val+" right = "+node.right.val);
                path_sum_stack.push(path_sum + node.right.val);
            }
            if(node.left != null) {
                tree_stack.push(node.left);
                //System.out.println("val ="+node.val+" left = "+node.left.val);
                path_sum_stack.push(path_sum + node.left.val);
            }
            if(node.left == null && node.right == null) {
                //System.out.println(path_sum);
                if(path_sum == sum) {
                    return true;
                }
            }
        }
        return false;
    }
    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        int i, len = A.length;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A[0]), node = root;
        queue.offer(node); 
        for(i = 1;i < len;i++) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == len) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void print(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        for(;;) {
            try{
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

public class HasPathSum {
    public static void main(String[] args) {
        //int[] A = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
        //int[] A = {};
        int[] A = {1};
        Solution sol = new Solution();
        sol.print(sol.growTree(A));
        if(sol.hasPathSum(sol.growTree(A),1)) {
            System.out.println("True!");
        }else {
            System.out.println("False!");
        }
    }
}




