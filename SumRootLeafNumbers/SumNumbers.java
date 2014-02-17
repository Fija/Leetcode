import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}
class Solution {
    int sum;
    int sumNumbers(TreeNode root) {
        preOrderTraversal(root);
        return sum;
    }
    void preOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }else {
            if(node.left == null && node.right == null) {
                sum += node.val;
            }else {
                if(node.left != null) {
                    node.left.val += node.val * 10;
                }
                if(node.right != null) {
                    node.right.val += node.val * 10;
                }
            }
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
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
public class SumNumbers {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{1},{1,2,3,-1,4},{1,2,-1,3},
                     {1,-1,3,-1,4},{1,2,3,4,5,6}};
        Solution[] sol = new Solution[A.length];
        for(int i = 0; i < A.length; i++) {
            sol[i] = new Solution();
            sol[i].printTree(sol[i].growTree(A[i]));
            System.out.println(sol[i].sumNumbers(sol[i].growTree(A[i])));
        }
    }
}

            
